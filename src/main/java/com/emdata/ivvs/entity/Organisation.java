package com.emdata.ivvs.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Organisation {
    private Integer oid;

    private String orgCode;

    private String orgName;

    private String orgParentCode;

    private Date createTime;

    private String remark;

    private Integer state;

    private Integer orderNumber;

}