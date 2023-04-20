package com.emdata.ivvs.entity;

import lombok.Data;

/**
 * Created   on 2019/7/1.
 */
@Data
public class ReasonTypeDict {
    Integer key;
    Integer active;
    String name;
    String show;

    String tabName = "";//定义查询未违法和疑似取值表
}
