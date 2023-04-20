package com.emdata.ivvs.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by wuqian on 2019/7/24.
 */

@Data
public class LogOperation {

    private Integer logId;
    private Date operTime;
    private Integer menuFunction;
    private String userUuid;
    private String userName;
    private String operDes;
}
