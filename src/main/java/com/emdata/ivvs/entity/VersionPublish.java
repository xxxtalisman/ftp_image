package com.emdata.ivvs.entity;


import lombok.Data;

/**
 * Created on 2019/7/10.
 */
@Data
public class VersionPublish {

    String uuid;
    String webVersion;
    String algVersion;
    String appVersion;
    String remark;
    String createTime;
    String publisher;


}
