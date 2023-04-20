package com.emdata.ivvs.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by tanglingxin on 2019/12/23.
 */
public interface ViolateCodeMapper {

    List<String> queryAllActive(Map<String,Object> map);
}
