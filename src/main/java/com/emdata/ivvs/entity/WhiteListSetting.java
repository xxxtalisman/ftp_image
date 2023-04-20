package com.emdata.ivvs.entity;

import lombok.Data;

/**
 * Created on 2019/8/8.
 */

@Data
public class WhiteListSetting {

    Long id;

    String lpn; //车牌号

    String lpType = ""; //号牌种类

    String lpTypeName = ""; //号牌种类

    String filterViolate = ""; //过滤违法行为

    Long createManUuid; //创建人uuid

    String createMan; //创建人

    String lpnPic = ""; //车牌照片保存路径

    String createAt; //创建时间

    String lifeStart;
    String lifeEnd; //期限

    String remark = ""; //描述

    String showFilterViolate = "";

    String showDetailsFilterViolate = "";

    Integer isDel; // 是否删除；0为正常，其他为删除

    String[] tidsArr = {};





}
