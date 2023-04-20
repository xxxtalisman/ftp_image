package com.emdata.ivvs.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * Created on 2019/7/2.
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "items")
public class ResourcesConfigItemsProperties {

    /**
     * 项目自定义配置
     */
    String projectAppName;
    String projectAppVersions;


    /**
     * 服务器存储目录
     */
    String serviceStoragePath;


    /**
     * 算法根据车牌图片识别车牌号请求地址
     */
    String algLpnDiscernUrl;



    /**
     * 配置文件上传大小
     */
    String serverMaxFileSize;
    String serverMaxRequestSize;

    /**
     * 应用和算法版本存放路径
     */
    String algAppVersions;


    /***南宁相关属性 start**/
    private String jizhiNngUrl;
    private String jizhiNngYhzh;
    private String jizhiNngYhmm;
    private String jizhiNngJkid;
    private String jizhiNngOpR;
    private String jizhiNngOpW;
    /***南宁相关属性 end**/


    /**
     * 秦皇岛集指相关配置参数
     */
    String soaShpUrl;
    String soapShpXtlb;
    String soapShpkklh;
    String soapShpJkid;


    /**
     * 保定集指相关配置参数
     */
    String soapBaoUrl;
    String soapBaoXtlb;
    String soapBaoJkxlh;
    String soapBaoJkid;

    /**
     * 淄博集指相关配置参数
     */
    String soapZibUrl;
    String soapZibXtlb;
    String soapZibJkxlh;
    String soapZibJkid;

    /**
     * 徐州集指相关配置参数
     */
    String soapXuzUrl;
    String soapXuzXtlb;
    String soapXuzJkxlh;
    String soapXuzJkid;

    /**
     * 秦皇岛六合一车辆信息配置参数
     */
    String soapShpVehicleUrl;
    String soapShpVehicleXtlb;
    String soapShpVehicleJkxlh;
    String soapShpVehicleJkid;
    String soapShpVehicleCsjqbh;
    String soapShpVehicleDwjgdm;
    String soapShpVehicleDwmc;
    String soapShpVehicleYhbz;
    String soapShpVehicleYhxm;
    String soapShpVehicleZdbs;


    /**
     * 苏州六合一车辆信息配置参数
     */
    String httpSzvVehicleUrl;


    /**
     * 保定为多台存储服务器指定图片存储服务器地址配置
     */
    String httpBaoNginxAddress;


    /**
     * 长治第三方对接配置参数
     */
    String httpCihUrl;
    String httpCihPort;


    /**
     * 苏州发送数据到第三方
     */
    String taskOutFtpAddress;
    Integer taskOutFtpPort;
    String taskOutFtpUser;
    String taskOutFtpPwd;
    String taskOutFtpJobPath;

    String taskGdOutFtpAddress;
    Integer taskGdOutFtpPort;
    String taskGdOutFtpUser;
    String taskGdOutFtpPwd;
    String taskGdOutFtpJobPath;

    //视频
    String taskOutVideoFtpAddress;
    Integer taskOutVideoFtpPort;
    String taskOutVideoFtpUser;
    String taskOutVideoFtpPwd;
    String taskOutVideoFtpJobPath;


    /**
     * 系统默认ftp用户配置参数
     */
    String systemLocalFtpAddress;
    Integer systemLocalFtpPort;
    String systemLocalFtpUser;
    String systemLocalFtpPwd;
    String systemLocalFtpJobPath;


    /**
     * web定义服务地址路径
     */
    private String webAddress;

    /**
     * web定义服务地址路径（路口场景）
     */
    private String webAddressCross;

    /**
     * ftp解析入库目录
     */
    String storeFtpWritePath;

    /**
     * ftp存储到本地目录
     */
    String storeSystemFacecollectPath;


    /**
     * 全局流程配置项值
     */
    //标记是否存在有延迟发送配置项值
    Boolean sendDelayStatusBool = Boolean.FALSE;
    //标记是否有延迟时间值
    Long sendDelayTimes = 0L;


    /***
     * 保定拉取集指审核结果日期偏移量
     * -1昨日
     */
    Integer pullOffset = -1;



    /***
     * 保定自动提交数据时间间隔
     * 算法输出时间-违法时间
     */
    private Integer notWarningTimeThreshold = 2 * 60;

    /***
     * 保定实时提交集指间隔阈值
     * 算法输出时间-违法时间
     */
    private Integer warningTimeThreshold = 3;

}
