package com.emdata.ivvs.vo;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by tanglingxin on 2019/12/23.
 */
public class BaseVo implements Serializable{

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
