package com.emdata.ivvs.entity;

import lombok.Data;

/**
 * Created by wuqian on 2019/8/22.
 */

@Data
public class ActiveMqData {

    private Integer id;
    private Integer userId;
    private Integer type;
    private String text;
    private Integer faultInfoId;
    private Integer deleteStatus;
    private String createTime;
}
