package com.emdata.ivvs.service.impl;

import cn.hutool.core.date.DatePattern;
import com.emdata.analysis.bean.AnalysStrBean;
import com.emdata.analysis.service.AnalysisService;
import com.emdata.ivvs.common.constants.Constants;
import com.emdata.ivvs.common.utils.DateUtils;
import com.emdata.ivvs.common.utils.StringUtil;
import com.emdata.ivvs.config.FtpConfig;
import com.emdata.ivvs.dao.*;
import com.emdata.ivvs.service.HandleDataService;
import com.emdata.ivvs.utils.DateUtil;
import com.emdata.ivvs.utils.DownloadFileUtil;
import com.emdata.ivvs.utils.FtpCli;
import com.emdata.ivvs.utils.sf.SnowFlaskInstance;
import com.emdata.ivvs.vo.InsertSourceVo;
import com.emdata.ivvs.vo.RuleVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by txw on 2019/12/23.
 */
@Service
public class HandleFtpDataService implements HandleDataService,CommandLineRunner{

    @Resource(name = "defaultFtpConfig")
    private FtpConfig ftpConfig;

    @Resource(name = "analysisFtpStr")
    private AnalysisService analysisService;

    @Autowired
    private SbbhinfoMapper sbbhinfoMapper;

    @Autowired
    private ViolateCodeMapper violateCodeMapper;

    @Autowired
    private SourceDataMapper sourceDataMapper;

    @Autowired
    private FtpDataConfigMapper ftpDataConfigMapper;

    @Autowired
    private PutDataDao putDataDao;

    @Value("${localPath}")
    private String localPath;

    @Value("${cityCode}")
    private String cityCode;

    @Value("${serverId}")
    private Integer fid;

    private static LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>(Integer.MAX_VALUE);

	/*
	 * private static ThreadPoolExecutor dataPool = new ThreadPoolExecutor(0, 100,
	 * 20L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	 */
    
    static ThreadPoolExecutor dataPool = new ThreadPoolExecutor(0,4,60,TimeUnit.MILLISECONDS,new ArrayBlockingQueue(50),new ThreadPoolExecutor.CallerRunsPolicy());
    

    private static Logger logger = LoggerFactory.getLogger(HandleFtpDataService.class);
    @Override
    public void handleRemoteFile(String dateStr) {
    	logger.info("start");
        //创建ftp链接
        FtpCli ftpCli = FtpCli.createFtpCli(ftpConfig.getHost(),ftpConfig.getPort(),ftpConfig.getUsername(),ftpConfig.getPassword(),ftpConfig.getChatSet());
        try {
            ftpCli.connect();
            //得到所有文件的名称 (得到的是文件的名称)
            List<String> fileNames = this.getAllFileNames(ftpCli,ftpConfig.getBasePath());
            if (CollectionUtils.isEmpty(fileNames)){
                logger.info("没有文件需要处理");
                return;
            }else {
                logger.info("取得文件名称成功");
            }
            //查询出对应的规则
            RuleVo ruleVoParams = new RuleVo();
            ruleVoParams.setFid(fid);
            List<RuleVo> rules = ftpDataConfigMapper.queryLastestConfig(ruleVoParams);
            if (CollectionUtils.isEmpty(rules)){
                logger.info("无可用配置，本次任务结束");
                return;
            }
            RuleVo rule = rules.get(0);
            //过滤出需要处理的文件 和不需要处理的文件
            logger.info("开始过滤文件 ");
            Map<String,InsertSourceVo> map = this.filterFile(rule,fileNames);
            logger.info("结束过滤文件 ");
            if (MapUtils.isEmpty(map)){
                logger.info("没有合法的文件需要处理");
                return;
            }
            logger.info("本次需要处理的文件个数为:{}",map.size());
        }catch (Exception e){
            logger.error("ftp链接失败",e);
            ftpCli.disconnect();
            return;
        }
        logger.info("end");

    }

    private String checkDateStr(String dateStr){
        if (StringUtil.isEmpty(dateStr)){
            return DateUtils.getDateTime(DatePattern.NORM_DATE_PATTERN,DateUtils.addDay(new Date(),-1));
        }else{
            try {
                /**转换成对应的格式*/
                Date date = DateUtils.convertStringToDate(DatePattern.NORM_DATE_PATTERN,dateStr);
                return DateUtils.getDateTime(DatePattern.NORM_DATE_PATTERN,date);
            }catch (Exception e){
                logger.error("日期格式不对",e);
            }
        }
        return null;
    }

    private List<String> getAllFileNames(FtpCli ftpCli,String path) {
        try {
            List<String> filenames =  ftpCli.listFileNames(path);
            if (CollectionUtils.isNotEmpty(filenames)){
                List<String> newFilenames = new ArrayList<>();
                filenames.forEach(s -> newFilenames.add(s.substring(s.lastIndexOf("/")+1)));
                logger.info("本次从ftp上遍历出文件数量:{}",filenames.size());
                return newFilenames;
            }
        }catch (Exception e){
            logger.error("error to getFileNames from Ftp",e);
        }finally {
            if (ftpCli != null){
                ftpCli.disconnect();
            }
        }
        return null;
    }
    

    private Map<String,InsertSourceVo> filterFile(RuleVo rule,List<String> fileNames){
        Map<String,InsertSourceVo> map = new HashMap<>();
        AnalysStrBean<InsertSourceVo> bean = new AnalysStrBean<>();
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("access_state","1");
        queryMap.put("status","1");
        //List<String> sbbhinfos = sbbhinfoMapper.selectList(queryMap);
        queryMap.put("del","0");
        queryMap.put("receive_status","0");
        //List<String> activeCodes = violateCodeMapper.queryAllActive(queryMap);
        //从文件中过滤出视频文件
        fileNames.forEach(s -> {
            if (s.endsWith("mp4")||s.endsWith("MP4")||s.endsWith("avi")||s.endsWith("AVI")){
                //视频文件跳过不处理 图片中带视频的文件需要同时下载
                //TODO 为视频文件在进行一个处理,针对视频大文件不和图片一起设备接入进来的
                InsertSourceVo vo = null;
                try {
                    if(s.lastIndexOf(Constants.SYMBOL_SPOT)!=-1) {

                        /*bean.setRule(rule);
                        bean.setCla(InsertSourceVo.class);
                        bean.setFileName(s.substring(0, s.lastIndexOf(Constants.SYMBOL_SPOT)));
                        InsertSourceVo ruleVo = analysisService.analysis(bean);
                        if(null == ruleVo){
                            logger.info("视频文件{}不符合配置规则格式",s);
                            try {
                                delMismatchFile(s);
                            }catch (Exception e){}
                            return;
                        }
                        String violateDay = DateUtils.getCurrentDateWfsj(ruleVo.getWfsj());
                        FtpCli ftpCli = FtpCli.createFtpCli(ftpConfig.getHost(),ftpConfig.getUsername(),ftpConfig.getPassword(),ftpConfig.getChatSet());
                        try {
                            ftpCli.connect();
                            String repeatVideoName = localPath+violateDay+"/"+s;
                            if (new File(repeatVideoName).exists()) {
                                ftpCli.deleteFile(ftpConfig.getBasePath()+ "/" + s);
                            }
                        }catch (Exception e){
                            logger.info("文件{}删除失败",s);
                            return;
                        }finally {
                            if (ftpCli  != null) {
                                ftpCli.disconnect();
                            }
                        }*/

                        //根据文件名称去掉后缀去查询该条数据是否有对应的数据
                        InsertSourceVo insertSourceVoParams = new InsertSourceVo();
                        String strVideoFile = s.substring(0, s.lastIndexOf(Constants.SYMBOL_SPOT));
                        if (StringUtils.isNotBlank(strVideoFile)) {
                            insertSourceVoParams.setZpwjm(strVideoFile);
                            vo = sourceDataMapper.selectSelective(insertSourceVoParams);
                        }
                    }else{
                        logger.info("视频文件{}不符合数据解析格式",s);
                    }
                }catch (Exception e){
                    logger.info("视频文件{}不符合数据关联条件",s);
                }
                if (!Objects.isNull(vo) && vo.getUuid() > 0L){
                    Runnable runnable = this.getProduceRunnableVideo(s,vo);
                    blockingQueue.add(runnable);
                    map.put(s,vo);
                }else{
                    logger.info("视频文件{}无匹配数据库图片数据",s);
                    delMismatchFile(s);
                }
            }else{
                //TODO 图片数据格式数据
                bean.setRule(rule);
                bean.setCla(InsertSourceVo.class);
                //去掉后缀
                if(s.indexOf(Constants.SYMBOL_SPOT)!=-1) {
                    bean.setFileName(s.substring(0, s.lastIndexOf(Constants.SYMBOL_SPOT)));
                }else{
                    bean.setFileName(s);
                    return;
                }
                InsertSourceVo vo = null;
                try {
                    //根据rule规则把文件名解析成需要的入库对象
                    vo = analysisService.analysis(bean);
                }catch (Exception e){
                    logger.info("文件{}不符合配置",s);
                    delMismatchFile(s);
                }
                if (!Objects.isNull(vo)){
                    String day = "";
                    try {
                        day = DateUtils.getCurrentDateWfsj(vo.getWfsj());
                    }catch (Exception e){
                        logger.error("数据格式违法时间不匹配 file name is {}",s);
                        delMismatchFile(s);
                    }
                    if(StringUtils.isBlank(day)){
                        return;
                    }
                    String absoulteName = localPath+day+"/"+s;
                    if (new File(absoulteName).exists()) {
                        logger.info("文件{}已处理完,不进行重复处理",s);
                        FtpCli ftpCliRepeat = FtpCli.createFtpCli(ftpConfig.getHost(),ftpConfig.getPort(),ftpConfig.getUsername(),ftpConfig.getPassword(),ftpConfig.getChatSet());
                        try {
                            ftpCliRepeat.connect();
                            //删除已存在图片文件
                            ftpCliRepeat.deleteFile(ftpConfig.getBasePath()+"/"+s);
                            //删除存在关联视频,遍历视频包含格式
                            String videoPath = this.checkVideoPath(ftpConfig.getVideoSuffix(),fileNames,s);
                            //判断本地是否存在文件
                            if(StringUtils.isNotBlank(videoPath) && new File(localPath+day+"/"+videoPath).exists()) {
                                //删除视频
                                ftpCliRepeat.deleteFile(videoPath);
                            }
                        }catch (Exception e){
                            logger.error("{}文件删除失败,Can't remove file from FTP server.",s);
                        }
                        finally {
                            if (ftpCliRepeat  != null){
                                ftpCliRepeat.disconnect();
                            }
                        }
                        return;
                    }
                    /*if (!sbbhinfos.contains(vo.getSbbh())){
                        //如果不包含这个sbbh，说明这个sbbh未开启
                        logger.info("设备{}限制接入数据",vo.getSbbh());
                        return;
                    }

                    if (!activeCodes.contains(vo.getWfxw())){
                        //logger.info("违法行为{}限制接入数据",vo.getWfxw());
                        //return;
                    }
                    */
                    if (StringUtil.isEmpty(vo.getHphm())) {
                        logger.info("文件{}的文件名中不包含号牌号码",s);
                        delMismatchFile(s);
                        return;
                    }
                    if (StringUtil.isEmpty(vo.getHpzl())){
                        logger.info("文件{}的文件名中不包含号牌种类",s);
                        delMismatchFile(s);
                        return;
                    }
                    if (vo.getWfsj() ==  null){
                        logger.info("文件{}的文件名中不包含违法时间",s);
                        delMismatchFile(s);
                        return;
                    }
                    //判断是否携带有视频
                    vo.setWfspdz(null);
                    if(s.indexOf(".")!=-1) {
                        String videoPath = this.checkVideoPath(ftpConfig.getVideoSuffix(),fileNames,s);
                        if(StringUtils.isNotBlank(videoPath)){
                            vo.setWfspdz(videoPath);
                        }
                    }
                    Runnable runnable = this.getProduceRunnable(s,vo);
                    blockingQueue.add(runnable);
                    map.put(s,vo);
                }else{
                    logger.info("文件{}不符合规则配置",s);
                }
            }
        });
        return map;
    }


    /**
     * 删除3天以内不匹配文件
     * @param s
     */
    private void delMismatchFile(String s){
        if (s.lastIndexOf(Constants.SYMBOL_SPOT) != -1) {
            FtpCli ftpCli = FtpCli.createFtpCli(ftpConfig.getHost(),ftpConfig.getPort(), ftpConfig.getUsername(), ftpConfig.getPassword(), ftpConfig.getChatSet());
            try {
                String fPath = ftpConfig.getBasePath() + "/" + s;
                ftpCli.connect();
                if(checkFileTime(fPath,ftpCli)){
                    ftpCli.deleteFile(fPath);
                }
            } catch (Exception e) {
                logger.info("delMismatchFile 文件{}删除失败", s);
                return;
            } finally {
                if (ftpCli != null) {
                    ftpCli.disconnect();
                }
            }
        }
    }


    /**
     * 检测ftp文件和当前时间相隔几天
     * @param pathFileName
     * @param ftpCli
     * @return
     */
    private Boolean checkFileTime(String pathFileName,FtpCli ftpCli){
        Boolean bl = Boolean.FALSE;
        try {
            Date date = new Date();
            //YYYYMMDDhhmmss
            String times = ftpCli.getlastmodifyTime(pathFileName);
            Date mDate = DateUtil.parseStrToDate(times);
            //计算与当前时间差
            Long days = DateUtil.getDistanceTime(mDate,date);
            logger.info("checkFileTime days:{}",days);
            if(days >=2L){
                bl = Boolean.TRUE;
            }
        }catch (Exception e){
            logger.error("checkFileTime error {}",e.getMessage());
        }
        return bl;
    }


    /**
     * 检测视频文件是否有关联或者存在
     * @param videoSuffix
     * @return
     */
    private String checkVideoPath(String videoSuffix,List<String> fileNames,String fileName){
        String path = "";
        try {
            String[] videoSuffixList = StringUtils.split(videoSuffix, Constants.SYMBOL_UNDER);
            if(ArrayUtils.isNotEmpty(videoSuffixList)){
                for(String suffix : videoSuffixList){
                    boolean flag = fileNames.contains(fileName.substring(0, fileName.lastIndexOf(Constants.SYMBOL_SPOT)) + suffix);
                    if (flag) {
                        path = ftpConfig.getBasePath()+"/"+fileName.substring(0, fileName.lastIndexOf(Constants.SYMBOL_SPOT)) + suffix;
                        break;
                    }
                }
            }
        }catch (Exception e){
            logger.error("checkVideoPath Exception {} file is {}",videoSuffix,fileName);
        }
        return path;
    }


    /**
     * 检测图片文件
     * @param imageSuffix
     * @param fileNames
     * @param fileName
     * @return
     */
    private String checkImagePath(String imageSuffix,List<String> fileNames,String fileName){
        String path = "";
        try {
            String[] imageSuffixList = StringUtils.split(imageSuffix, Constants.SYMBOL_UNDER);
            if(ArrayUtils.isNotEmpty(imageSuffixList)){
                for(String suffix : imageSuffixList){
                    boolean flag = fileNames.contains(fileName.substring(0, fileName.lastIndexOf(Constants.SYMBOL_SPOT)) + suffix);
                    if (flag) {
                        path = ftpConfig.getBasePath()+Constants.SYMBOL_BAR+fileName.substring(0, fileName.lastIndexOf(Constants.SYMBOL_SPOT)) + suffix;
                        break;
                    }
                }
            }
        }catch (Exception e){
            logger.error("checkImagePath Exception {} file is ",imageSuffix,fileName);
        }
        return path;
    }

    /**
     *
     * @param
     * @param fileNames 取到的所有文件名
     * @param map 需要处理的文件
     */
    private void hanlerData(List<String> fileNames, Map<String,InsertSourceVo> map) {
        for (String fileName : fileNames){
            if (map.containsKey(fileName)){
                //一个线程生产 20个线程去消费
                //先判断一次此文件在本地是否存在，存在的话就不去处理说明此文件被下载且处理过
                File file = new File(localPath+fileName);
                if (file.exists()){
                    logger.info("文件{}已被下载过,数据将被替换",fileName);
                    //continue;
                }
                Runnable runnable = this.getProduceRunnable(fileName,map.get(fileName));
                blockingQueue.add(runnable);
            }else{

            }
        }
    }

    private Runnable getProduceRunnable(final String fileName,final InsertSourceVo insertSourceVo) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //下载文件到本地某个文件夹下面，这里初始化一下ftp链接，不用之前的链接了，用多个链接开启多个端口去下载
                //20个线程最多20个链接
            	//logger.info("开始处理文件：{}",fileName);
                FtpCli ftpCli = FtpCli.createFtpCli(ftpConfig.getHost(),ftpConfig.getPort(),ftpConfig.getUsername(),ftpConfig.getPassword(),ftpConfig.getChatSet());
                DownloadFileUtil.mkdir(localPath);
                try {
                    String absoulteName = ftpConfig.getBasePath()+fileName;
                    String shipingFileName = null;
                    String localShipinName = null;
                    ftpCli.connect();
                    String todayStr = "";
                    try {
                        todayStr = DateUtils.getCurrentDateWfsj(insertSourceVo.getWfsj());
                    }catch (Exception e){
                        //logger.error("insertSourceVo is {} file name is {}",insertSourceVo,fileName);
                    }
                    if(StringUtils.isBlank(todayStr)){
                        logger.info("文件{}时间格式位数不符合解析格式",fileName);
                        delMismatchFile(fileName);
                        return;
                    }
                    try {
                        File dirFile = new File(localPath + todayStr);
                        if (!dirFile.exists()){
                            dirFile.mkdirs();
                        }
                        ftpCli.download(absoulteName,new File(localPath+todayStr+"/"+fileName));
                    }catch (FileNotFoundException e){
                        logger.info("FTP文件{}已不存在",fileName);
                        return;
                    }
                    //logger.info("文件{}下载成功",fileName);
                    if (insertSourceVo.getWfspdz() != null){
                        shipingFileName = ftpConfig.getBasePath()+insertSourceVo.getWfspdz();
                        localShipinName = localPath+todayStr+"/"+insertSourceVo.getWfspdz();
                        ftpCli.download(shipingFileName,new File(localPath+todayStr+"/"+insertSourceVo.getWfspdz()));
                        logger.info("文件{}的视频文件{}下载成功",fileName,insertSourceVo.getWfspdz());
                    }
                    //入库操作
                    initFeild(insertSourceVo,fileName,localPath+todayStr+"/"+fileName,localShipinName);
                    Integer i = save(insertSourceVo);
                    //删掉ftp原始文件
                    if (i>0) {
                        logger.info("文件{}数据入库成功，开始删除ftp源文件",fileName);
                        ftpCli.deleteFile(absoulteName);
                        if (!StringUtil.isEmpty(shipingFileName)){
                            ftpCli.deleteFile(shipingFileName);
                        }
                    }
                }catch (Exception e){
                    logger.info("FTP文件{}下载失败,ftp happened error,{}",fileName,e);
                }finally {
                    if (ftpCli  != null){
                        ftpCli.disconnect();
                    }
                }
            }
        };
        return runnable;
    }



    private Runnable getProduceRunnableVideo(final String fileName,final InsertSourceVo insertSourceVo) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //下载文件到本地某个文件夹下面，这里初始化一下ftp链接，不用之前的链接了，用多个链接开启多个端口去下载
                //20个线程最多20个链接
                logger.info("开始处理视频文件：{}",fileName);
                FtpCli ftpCli = FtpCli.createFtpCli(ftpConfig.getHost(),ftpConfig.getPort(),ftpConfig.getUsername(),ftpConfig.getPassword(),ftpConfig.getChatSet());
                DownloadFileUtil.mkdir(localPath);
                try {
                    String shipingFileName = null;
                    String localShipinName = null;
                    ftpCli.connect();
                    String todayStr = DateUtils.getCurrentDateWfsj(insertSourceVo.getWfsj());
                    try {
                        File dirFile = new File(localPath + todayStr);
                        if (!dirFile.exists()){
                            dirFile.mkdirs();
                        }
                    }catch (Exception e){
                        logger.info("文件{}目录创建失败，查看是否有权限操作",fileName);
                        return;
                    }
                    if (StringUtils.isBlank(insertSourceVo.getWfspdz())){
                        //设置视频
                        shipingFileName = ftpConfig.getBasePath()+"/"+fileName;
                        localShipinName = localPath+todayStr+"/"+fileName;
                        ftpCli.download(shipingFileName,new File(localPath+todayStr+"/"+fileName));
                        logger.info("视频文件{}下载成功",fileName,fileName);
                    }else{
                        //logger.info("视频文件{}已关联处理,不进行重复处理",fileName);
                        shipingFileName = ftpConfig.getBasePath()+"/"+fileName;
                        ftpCli.deleteFile(shipingFileName);
                        return;
                    }
                    //修改操作
                    initFeildVideo(insertSourceVo,fileName,localPath+todayStr+"/"+fileName,localShipinName);
                    Integer i = update(insertSourceVo);
                    //删掉ftp原始文件
                    if (i>0) {
                        logger.info("文件{}数据视频入库成功，开始删除ftp源文件",fileName);
                        ftpCli.deleteFile(shipingFileName);
                    }else{
                        logger.info("文件{}数据视频入库失败...",fileName);
                    }
                }catch (Exception e){
                    logger.error("download file {} happened error",e);
                }finally {
                    if (ftpCli  != null){
                        ftpCli.disconnect();
                    }
                }
            }
        };
        return runnable;
    }



    /**
     * 新增
     * @param insertSourceVo
     * @return
     */
    private synchronized Integer save(InsertSourceVo insertSourceVo) {
        Integer i = 0;
        try {
            i = sourceDataMapper.insertSelective(insertSourceVo);
        }catch (DuplicateKeyException e){
            logger.error("DuplicateKey 车牌{}，违法时间{},违法行为{}已入库...",insertSourceVo.getHphm(),insertSourceVo.getWfsj(),insertSourceVo.getWfxw());
            i = 4;
        }
        return i;
    }



    /**
     * 修改
     * @param insertSourceVo
     * @return
     */
    private synchronized Integer update(InsertSourceVo insertSourceVo){
        Integer i = 0;
        try {
            i = sourceDataMapper.updateSelective(insertSourceVo);
        }catch (Exception e){
            logger.error("updateSelective is {} ",e.getMessage());
        }
        return i;
    }

    private void initFeildVideo(InsertSourceVo insertSourceVo,String originName ,String fileName,String shipingName) {
        insertSourceVo.setUuid(insertSourceVo.getUuid());
        if (StringUtil.isEmpty(shipingName)){
            insertSourceVo.setWfspdz(null);
        }else{
            //设置违法视频地址
            insertSourceVo.setWfspdz(shipingName.replace("/data/public",""));
        }
    }



    private void initFeild(InsertSourceVo insertSourceVo,String originName ,String fileName,String shipingName) {
        insertSourceVo.setUuid(SnowFlaskInstance.getInstance().GetKeyGenerator().generateKey().longValue());
        insertSourceVo.setCreatetime(new Date());
        insertSourceVo.setUpdateTime(new Date());
        insertSourceVo.setIlocalremote(0);
        insertSourceVo.setZpwjm(originName);
        insertSourceVo.setZpstr1(fileName.replace("/data/public",""));
        if (StringUtil.isEmpty(shipingName)){
            insertSourceVo.setWfspdz("");
        }else{
            //设置违法视频地址
            insertSourceVo.setWfspdz(shipingName.replace("/data/public",""));
        }
        //违法地址&路口编号名称
        Map<String,Object> mpsPdaParams = new HashMap<>();
        mpsPdaParams.put("pdaSbbh",insertSourceVo.getSbbh());

        Map<String,Object> pdaMapObj =  putDataDao.selectPdaCardMouthByDevice(mpsPdaParams);
        //定义闯禁区和违停
        String caseIllName = "";
        if(pdaMapObj!=null && pdaMapObj.size()>0){
            insertSourceVo.setWfdd(String.valueOf(pdaMapObj.get("pdaNo")));
            insertSourceVo.setWfdz(String.valueOf(pdaMapObj.get("pdaName")));
            caseIllName = "wt01";
        }
        else{
            mpsPdaParams = new HashMap<>();
            mpsPdaParams.put("pdaNo",insertSourceVo.getSbbh());
            pdaMapObj =  putDataDao.selectPdaCardMouthByDevice(mpsPdaParams);
            if(pdaMapObj!=null && pdaMapObj.size()>0){
                insertSourceVo.setWfdd(String.valueOf(pdaMapObj.get("pdaNo")));
                insertSourceVo.setWfdz(String.valueOf(pdaMapObj.get("pdaName")));
            }
            else{
                insertSourceVo.setWfdd(insertSourceVo.getSbbh());
            }
            caseIllName = "cj01";
        }
        //TODO 2020.04.16 新增违法类型13441和pda设备以及gp01,gp02区分定义违法行为
        //新加苏州13441违法类型最后一位是否存在GP01
        if(StringUtils.isNotBlank(insertSourceVo.getWfxw()) && insertSourceVo.getWfxw().equals("13441")){
            if(StringUtils.isNotBlank(insertSourceVo.getGp01())){
                String gp01 = insertSourceVo.getGp01().toLowerCase();
                logger.info("info GP is {}",gp01);
                /*if(gp01.contains("gp0")){
                    insertSourceVo.setGp01(gp01);
                }
                else{
                    insertSourceVo.setGp01(caseIllName);
                }*/
                insertSourceVo.setGp01(gp01);
            }
            else{
                insertSourceVo.setGp01(caseIllName);
            }
        }
        //设置城市代码
        insertSourceVo.setCityCode(cityCode);
    }


    public void excuteQuene() {
        try {
            while(true){
                //采用阻塞队列的方式
            	Runnable able = blockingQueue.poll();
            	try {
                    if (able != null) {
                        dataPool.execute(able);
                    }
                }catch (Exception e){
                    logger.error("blockingQueue happended error",e);
                    Thread.sleep(55000);
                }
            }
        }catch (Exception e){
            logger.error("dataPool.execute(blockingQueue.poll()) happended error",e);
        }

    }

    @Override
    public void run(String... strings) throws Exception {
        new Thread(() -> {
            while (true){
                try {
                    if(blockingQueue.size() > 0){
                        Thread.sleep(65000);
                    }
                }catch (Exception e){}
                handleRemoteFile(null);
                try {
                    Thread.sleep(45000);
                }catch (Exception e){
                    logger.error("线程休眠异常");
                }
            }
        }).start();
        excuteQuene();
    }

	/*
	 * public static void main(String[] args) { new Thread(new Runnable() {
	 * 
	 * @Override public void run() { int i =0; while(i<10000) {
	 * blockingQueue.add(get()); }
	 * 
	 * } }) .start(); try {
	 * 
	 * while(true){ //采用阻塞队列的方式 Runnable able = blockingQueue.poll(); if (able !=
	 * null) { dataPool.execute(able);; }
	 * 
	 * } } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * public static Runnable get() { return new Runnable() {
	 * 
	 * @Override public void run() {
	 * System.out.println(Thread.currentThread().getName()); } }; }
	 */
}
