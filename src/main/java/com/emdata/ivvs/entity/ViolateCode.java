package com.emdata.ivvs.entity;

import lombok.Data;

import java.util.Date;

/**
 * violate_code实体类
 *
 * @author
 */
@Data
public class ViolateCode {
    /**
     * 主键
     */
    private Long uuid;
    /**
     * 内部违法类型
     */
    private Integer internalViolateType;
    /**
     * 违法代码
     */
    private String code;
    /**
     * 违法代码
     */
    private String secondaryCode;
    /**
     * 是否发送第三方 0-启用 1禁用
     */
    private Integer isSend;
    /**
     * 对应的算法代码
     */
    private Integer algType;
    /**
     * 是否激活
     */
    private Integer active;
    /**
     * 是否逻辑删除
     */
    private Integer del;
    /**
     * 名字
     */
    private String name;
    /**
     * 违法规则名称
     */
    private String regulationName;
    /**
     * 国标code
     */
    private String nationalStandardCode;
    /***/
    private String text;
    /**
     * 回写第三方违法代码
     */
    private String thirdPartyCode;
    /***/
    private Date createTime;
    /***/
    private Date updateTime;
    /**
     * 违法类型监控预警值
     */
    private String cvmValue;
    /**
     * 接收状态0开启，1关闭
     */
    private Integer receiveStatus;
    /**
     * 智审状态0开启，1关闭
     */
    private Integer checkStatus;
    /**
     * 异常监控0开启，1关闭
     */
    private Integer monitorStatus;

}
