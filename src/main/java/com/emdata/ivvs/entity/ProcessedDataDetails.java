package com.emdata.ivvs.entity;

import lombok.Data;

@Data
public class ProcessedDataDetails extends ProcessedData{

    String algLpColor=""; //车牌颜色
    String algCarType=""; //车辆类型
    String algMainBrand=""; //车辆主品牌
    String algCarColor=""; //车身颜色
    String algUsageType=""; //使用性质;车辆用途

    String zt=""; //机动车状态
    String carOwner=""; //车主姓名
    String carDeadlines=""; //车辆期限

    String imgWidth=""; //图片宽度
    String imgHeight=""; //图片高度

    String videoPath=""; //视频地址
    String srcPicPath=""; //图片地址
    String algPicPath=""; //算法效果图片地址
    String lpnScreenshotPath=""; //车牌截图

    String compositePicturePath="";  //后台保存图片合成照片
    String algProcessedPicturePath=""; //算法解析图片
    String srcVideoPath=""; //原视频地址

    //字典加名称显示字段
    String showSrcLpType = ""; //显示的号牌种类
    String showMargeLpType = "";
    String showAlgLpType = "";

    String amendReason=""; //改判原因
    String division=""; //行政区划
    String carLane=""; //车道
    String carSpeed=""; //车速
    String carClassify=""; //车辆分类

    String deviceOrientation=""; //设备朝向
    String capSpeed=""; //抓拍车速(实测值)
    String speedLimitValue="";//限速值(标准值)

    Integer restrictionType;//限行类型
    String restrictionTypeName="";//限行类型名称
    String restrictionName="";//限行规则名称
    String restrictionNo="";//限行尾号

    Integer inputSrcCount; //原始图片数量
    String inputDataSrcPath1; //原始图片地址1
    String inputDataSrcPath2=""; //原始图片地址2
    String inputDataSrcPath3=""; //原始图片地址3
    String inputDataSrcPath4=""; //原始图片地址4
    String inputDataSrcPath5=""; //原始图片地址5
    String inputDataSrcPath6=""; //原始图片地址6

    Integer notIllegalReasonType; //未违法原因
    Integer notSureReasonType;  //疑似原因
    Integer illegalReasonType; //违法原因类型

    Integer abnormalReasonType; //异常作废类型
    String reasonDict=""; //原因值

    String splitSrcLpn0 = ""; //截取的lpn前一位，wj为前两位
    String splitSrcLpn1 = ""; //截取的除了前面之外的值

    String trId; //traffic_restriction_info表的id


}
