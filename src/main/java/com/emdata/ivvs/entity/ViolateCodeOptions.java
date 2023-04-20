package com.emdata.ivvs.entity;

import lombok.Data;

/**
 * Created on 2019/7/1.
 */
@Data
public class ViolateCodeOptions {

    Integer violateType; //违法代码id
    String code; //违法代码
    Long algType; //对应的算法代码
    String showName; //显示的拼接名称
    String name; //违法名称
    String thirdPartyCode; //回写第三方违法代码
}
