package com.emdata.ivvs.entity;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

@Data
public class ProcessedData {

    String processedDataId = "";
    String sourceDataId = "";
    String carId;
    Integer isRead;

    String dataStatus; //数据状态

    Integer algStatus;
    Integer margeStatus;

    String srcLpType = ""; //前端上次号牌种类
    String margeLpType = ""; //号牌种类
    String algLpType =""; //算法解析号牌种类

    String srcLpn = "";//前端上传车牌号
    String algLpn = ""; //新增算法识别车牌号
    String margeLpn = ""; //车牌号

    Boolean lpnSrc2Alg;  //车牌号码是否一致
    Boolean carTypeSrc2Alg; //车型是否一致

    String isAmend = ""; //是否改判
    String showAmend=""; //显示是否改判

    String submitAt = ""; //提交时间
    String violateAt = ""; //违法时间
    String createdAt = ""; //入库时间
    String algFinishAt = ""; //算法解析完成时间

    String distributionToUserId=""; //分配人ID
    String distributionToUserName=""; //分配人

    String submitToUserId=""; //提交人ID
    String submitToUserName=""; //提交人
    String sobotId=""; //用户编号

    String showMargeLpType = ""; //显示的号牌种类

    String showMargeStatus = ""; //显示人审结果
    String showAlgStatus = ""; //显示机审结果

    Integer deviceId; //设备Id
    String deviceNo = ""; //设备编号
    String deviceName = ""; //设备名称


    Long srcViolateType ;//原违法类型编号
    Long margeViolateType;//违法类型编号
    Long algViolateType;//算法违法类型编号

    String srcViolateCode = "";//原违法类型代码
    String margeViolateCode = "";//违法类型代码
    String algViolateCode = "";//算法违法类型代码
    String modifyViolateCode = "";//修改前违法类型代码

    String srcViolateName = "";//原违法类型名称
    String margeViolateName = "";//违法类型名称
    String algViolateName = "";//算法违法类型名称
    String modifyViolateName = "";//修改前违法类型名称

    String showSrcViolate = "";//显示的原违法类型code+name
    String showAlgViolate = ""; //显示的算法违法行为
    String showMargeViolate = ""; //显示的违法行为

    String illegalPlace=""; //路口编号
    String illegalPlaceName=""; //路口名称

    Long dataFromType;//来源类型
    String dataFromName = "";//来源名称

    Integer isSendStatus; //回传状态
    Integer abnormalReasonType; //异常作废值
    String showSendState = "";//发送状态描述

    String reasonDict=""; //原因值
    Integer isExamine; //是否审核


    //改判提交标记
    String commuteStatus = ""; //改判提交状态  0-改判未违法 1-改判违法

    Integer isDel;


    public  String getSrcLpType(){
        return getLpType(srcLpType);
    }
    public String getMargeLpType(){
        return getLpType(margeLpType);
    }
    public String getAlgLpType(){
        return getLpType(algLpType);
    }


    //返回位数为1位的号牌种类补0
    protected String getLpType(String lpType){
        if(StringUtils.isNotBlank(lpType) && lpType.length()==1){
            lpType ="0"+lpType;
        }
        return lpType;
    }


}
