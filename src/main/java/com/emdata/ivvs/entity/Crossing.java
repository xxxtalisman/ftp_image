package com.emdata.ivvs.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Crossing {

    /**
     * 路口id
     */
    Integer cid;
    String ccode; //路口编号
    String cname; //路口名称
    String sbbh; //设备编号
    String sbid;  //设备号

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 修改日期
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 1启用，2禁用
     */
    private String states;

    String showName; //显示的拼接名称
}
