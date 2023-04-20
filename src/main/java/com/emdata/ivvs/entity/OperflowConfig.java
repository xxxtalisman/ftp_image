package com.emdata.ivvs.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created on 2019/7/18.
 */
@Data
public class OperflowConfig {

    @ApiModelProperty(value="主键" ,required = false, hidden = true)
    Integer oid; //

    @ApiModelProperty(value="回写数据类型，默认0,全部；1,违法数据；10,违法+疑似；" ,required = true,notes="默认0,全部；1,违法数据；10,违法+疑似；")
    Long send_violate_status; //发送回写第三方违法值；默认0,全部；1,违法数据；2,未违法；10,违法+疑似；12，违法+未违法；
    @ApiModelProperty(value="回写数据方式，默认0,实时；其他,分钟数值" ,required = true,notes="默认0,实时；其他,分钟数值")
    Long send_delay_status; //发送延迟时间；0,实时;其他,分钟数值
    @ApiModelProperty(value="数据超时阈值，单位天数；默认10个工作日；" ,required = true,notes="默认10个工作日；")
    Long data_timeout_threshold; //超时日期阈值;默认10个工作日
    @ApiModelProperty(value="用户登录阈值，默认0,不限；" ,required = true,notes="默认0,不限；")
    Long user_logins_count = 0L; //用户登录次数
    @ApiModelProperty(value="锁屏时长阈值,单位分钟；默认10分钟；" ,required = true,notes="默认10分钟；")
    Long shiro_timeout_session; //(重启服务生效)登录用户session超时时间,单位为ms;默认为10分钟;
    @ApiModelProperty(value="账户有效期阈值.默认3个月；" ,required = true,notes="默认3个月；")
    Long account_limited_threshold; //用户有效期阈值,单位为月，默认为3个月
    @ApiModelProperty(value="算法解析时间，默认0,实时；" ,required = true,notes="默认0,实时；")
    Long alg_processing_times; //算法解析延迟时间；0,实时;其他,秒数值

}
