package com.emdata.ivvs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * Created by tanglingxin on 2019/12/24.
 */
public class FtpDataConfig {

    /**
     * 唯一识别号uuid
     */
    @TableId(value = "uuid", type = IdType.AUTO)
    private Long uuid;

    /**
     * 设备编号
     */
    private String sbbh;

    /**
     * 执勤民警,警员代号
     */
    private String zqmj;

    /**
     * 车辆分类
     */
    private String clfl;

    /**
     * 号牌种类
     */
    private String hpzl;

    /**
     * 号牌号码
     */
    private String hphm;

    /**
     * 违法地行政区划
     */
    private String xzqh;

    /**
     * 违法地点
     */
    private String wfdd;

    /**
     * 路段代码,公里数
     */
    private String lddm;

    /**
     * 地点米数
     */
    private String ddms;

    /**
     * 违法地址
     */
    private String wfdz;

    /**
     * 违法时间
     */
    private Date wfsj;

    /**
     * 违法时间1
     */
    private Date wfsj1;

    /**
     * 违法行为
     */
    private String wfxw;

    /**
     * 实测值
     */
    private String scz;

    /**
     * 标准值
     */
    private String bzz;

    /**
     * 照片数量
     */
    private Integer zpsl;

    /**
     * 图片文件名
     */
    private String zpwjm;

    /**
     * 照片1
     */
    private String zpstr1;

    /**
     * 照片2
     */
    private String zpstr2;

    /**
     * 照片3
     */
    private String zpstr3;

    /**
     * 照片4
     */
    private String zpstr4;

    /**
     * 违法视频地址
     */
    private String wfspdz;

    /**
     * 0: 本地; 1: 远程
     */
    private Integer ilocalremote;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * （苏州）方向代码*0北向南1西向东2南向北3东向西4东南5东北6西南7西北9其它
     */
    private String fxdm;

    /**
     * （苏州）管辖部门*12位管辖部门编号（民警所在部门），由交警部门指定
     */
    private String gxbm;

    /**
     * （苏州）用户代码
     */
    private String yhdm;

    /**
     * 闯红灯设备为1；公路卡口设备为2；测速设备为3；闭路电视为4；移动摄像为5；警务通设备为6；区间测速为7；其他电子设备为9；
     */
    private String sjly;

    /**
     * (苏州)车道号1位；按车辆行驶方向，从左到右开始编码
     */
    private String cdh;

    /**
     * （苏州）车架号车架号，为空用NULL代替，黄标车违法为必填项
     */
    private String cjh;

    /**
     * (苏州)区间测速结束时间
     */
    private Date qjcssj;

    /**
     * 数据来源(1-，2-，3-，4-，10-海康，11-宇视)
     */
    private String datasource;

    /**
     * 处理状态
     */
    private String status;

    /**
     * 违法行为名称
     */
    private String wfxwmc;

    private String sfjtp;

    /**
     * 车辆品牌
     */
    private String clpp;

    /**
     * 车身颜色
     */
    private String csys;

    private String sfhhdj;

    /**
     * 序号
     */
    @TableField("Xh")
    private String Xh;

    private String cdbh;

    /**
     * 号牌颜色
     */
    private String hpys;

    /**
     * 行驶方向
     */
    private String xsfx;

    /**
     * 车辆类型
     */
    private String cllx;

    /**
     * 发证机关
     */
    private String fzjg;

    /**
     * 机动车所有人
     */
    private String jdcsyr;

    /**
     * 交通方式
     */
    private String jtfs;

    /**
     * 住所行政区划
     */
    private String zsxzqh;

    /**
     * 电话
     */
    private String dh;

    /**
     * 联系方式
     */
    private String lxfs;

    /**
     * 是否提供校车服务
     */
    private String xcfw;

    /**
     * 金华新增人工审核字段
     */
    private String jdzt;

    /**
     * 金华新增人工审核字段
     */
    private String jdjg;

    /**
     * 算法是否解析成功，-2正在解析，-1,未解析;0,未成功;1,成功
     */
    private Integer algStatus;

    private Long algUuid;

    /**
     * 摄像机编号
     */
    private String sxjbh;

    /**
     * 苏州识别为高排污车辆字段
     */
    private String gp01;

    /**
     * 算法错误代码
     */
    private Integer algErrCode;

    /**
     * 唯一编号（连云港用）
     */
    private String viewId;


    /**
     * 城市代码
     */
    private String cityCode;


    /**
     * 算法处理次数
     */
    private Integer algTimes;

    /**
     * 发送第三方状态
     */
    private Integer sendThirdParty;

    /**
     * 发送次数
     */
    private Integer sendTimes;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh;
    }

    public String getZqmj() {
        return zqmj;
    }

    public void setZqmj(String zqmj) {
        this.zqmj = zqmj;
    }

    public String getClfl() {
        return clfl;
    }

    public void setClfl(String clfl) {
        this.clfl = clfl;
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl;
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm;
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    public String getWfdd() {
        return wfdd;
    }

    public void setWfdd(String wfdd) {
        this.wfdd = wfdd;
    }

    public String getLddm() {
        return lddm;
    }

    public void setLddm(String lddm) {
        this.lddm = lddm;
    }

    public String getDdms() {
        return ddms;
    }

    public void setDdms(String ddms) {
        this.ddms = ddms;
    }

    public String getWfdz() {
        return wfdz;
    }

    public void setWfdz(String wfdz) {
        this.wfdz = wfdz;
    }

    public Date getWfsj() {
        return wfsj;
    }

    public void setWfsj(Date wfsj) {
        this.wfsj = wfsj;
    }

    public Date getWfsj1() {
        return wfsj1;
    }

    public void setWfsj1(Date wfsj1) {
        this.wfsj1 = wfsj1;
    }

    public String getWfxw() {
        return wfxw;
    }

    public void setWfxw(String wfxw) {
        this.wfxw = wfxw;
    }

    public String getScz() {
        return scz;
    }

    public void setScz(String scz) {
        this.scz = scz;
    }

    public String getBzz() {
        return bzz;
    }

    public void setBzz(String bzz) {
        this.bzz = bzz;
    }

    public Integer getZpsl() {
        return zpsl;
    }

    public void setZpsl(Integer zpsl) {
        this.zpsl = zpsl;
    }

    public String getZpwjm() {
        return zpwjm;
    }

    public void setZpwjm(String zpwjm) {
        this.zpwjm = zpwjm;
    }

    public String getZpstr1() {
        return zpstr1;
    }

    public void setZpstr1(String zpstr1) {
        this.zpstr1 = zpstr1;
    }

    public String getZpstr2() {
        return zpstr2;
    }

    public void setZpstr2(String zpstr2) {
        this.zpstr2 = zpstr2;
    }

    public String getZpstr3() {
        return zpstr3;
    }

    public void setZpstr3(String zpstr3) {
        this.zpstr3 = zpstr3;
    }

    public String getZpstr4() {
        return zpstr4;
    }

    public void setZpstr4(String zpstr4) {
        this.zpstr4 = zpstr4;
    }

    public String getWfspdz() {
        return wfspdz;
    }

    public void setWfspdz(String wfspdz) {
        this.wfspdz = wfspdz;
    }

    public Integer getIlocalremote() {
        return ilocalremote;
    }

    public void setIlocalremote(Integer ilocalremote) {
        this.ilocalremote = ilocalremote;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFxdm() {
        return fxdm;
    }

    public void setFxdm(String fxdm) {
        this.fxdm = fxdm;
    }

    public String getGxbm() {
        return gxbm;
    }

    public void setGxbm(String gxbm) {
        this.gxbm = gxbm;
    }

    public String getYhdm() {
        return yhdm;
    }

    public void setYhdm(String yhdm) {
        this.yhdm = yhdm;
    }

    public String getSjly() {
        return sjly;
    }

    public void setSjly(String sjly) {
        this.sjly = sjly;
    }

    public String getCdh() {
        return cdh;
    }

    public void setCdh(String cdh) {
        this.cdh = cdh;
    }

    public String getCjh() {
        return cjh;
    }

    public void setCjh(String cjh) {
        this.cjh = cjh;
    }

    public Date getQjcssj() {
        return qjcssj;
    }

    public void setQjcssj(Date qjcssj) {
        this.qjcssj = qjcssj;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWfxwmc() {
        return wfxwmc;
    }

    public void setWfxwmc(String wfxwmc) {
        this.wfxwmc = wfxwmc;
    }

    public String getSfjtp() {
        return sfjtp;
    }

    public void setSfjtp(String sfjtp) {
        this.sfjtp = sfjtp;
    }

    public String getClpp() {
        return clpp;
    }

    public void setClpp(String clpp) {
        this.clpp = clpp;
    }

    public String getCsys() {
        return csys;
    }

    public void setCsys(String csys) {
        this.csys = csys;
    }

    public String getSfhhdj() {
        return sfhhdj;
    }

    public void setSfhhdj(String sfhhdj) {
        this.sfhhdj = sfhhdj;
    }

    public String getXh() {
        return Xh;
    }

    public void setXh(String xh) {
        Xh = xh;
    }

    public String getCdbh() {
        return cdbh;
    }

    public void setCdbh(String cdbh) {
        this.cdbh = cdbh;
    }

    public String getHpys() {
        return hpys;
    }

    public void setHpys(String hpys) {
        this.hpys = hpys;
    }

    public String getXsfx() {
        return xsfx;
    }

    public void setXsfx(String xsfx) {
        this.xsfx = xsfx;
    }

    public String getCllx() {
        return cllx;
    }

    public void setCllx(String cllx) {
        this.cllx = cllx;
    }

    public String getFzjg() {
        return fzjg;
    }

    public void setFzjg(String fzjg) {
        this.fzjg = fzjg;
    }

    public String getJdcsyr() {
        return jdcsyr;
    }

    public void setJdcsyr(String jdcsyr) {
        this.jdcsyr = jdcsyr;
    }

    public String getJtfs() {
        return jtfs;
    }

    public void setJtfs(String jtfs) {
        this.jtfs = jtfs;
    }

    public String getZsxzqh() {
        return zsxzqh;
    }

    public void setZsxzqh(String zsxzqh) {
        this.zsxzqh = zsxzqh;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getLxfs() {
        return lxfs;
    }

    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }

    public String getXcfw() {
        return xcfw;
    }

    public void setXcfw(String xcfw) {
        this.xcfw = xcfw;
    }

    public String getJdzt() {
        return jdzt;
    }

    public void setJdzt(String jdzt) {
        this.jdzt = jdzt;
    }

    public String getJdjg() {
        return jdjg;
    }

    public void setJdjg(String jdjg) {
        this.jdjg = jdjg;
    }

    public Integer getAlgStatus() {
        return algStatus;
    }

    public void setAlgStatus(Integer algStatus) {
        this.algStatus = algStatus;
    }

    public Long getAlgUuid() {
        return algUuid;
    }

    public void setAlgUuid(Long algUuid) {
        this.algUuid = algUuid;
    }

    public String getSxjbh() {
        return sxjbh;
    }

    public void setSxjbh(String sxjbh) {
        this.sxjbh = sxjbh;
    }

    public String getGp01() {
        return gp01;
    }

    public void setGp01(String gp01) {
        this.gp01 = gp01;
    }

    public Integer getAlgErrCode() {
        return algErrCode;
    }

    public void setAlgErrCode(Integer algErrCode) {
        this.algErrCode = algErrCode;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getAlgTimes() {
        return algTimes;
    }

    public void setAlgTimes(Integer algTimes) {
        this.algTimes = algTimes;
    }

    public Integer getSendThirdParty() {
        return sendThirdParty;
    }

    public void setSendThirdParty(Integer sendThirdParty) {
        this.sendThirdParty = sendThirdParty;
    }

    public Integer getSendTimes() {
        return sendTimes;
    }

    public void setSendTimes(Integer sendTimes) {
        this.sendTimes = sendTimes;
    }
}
