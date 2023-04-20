package com.emdata.ivvs.dao;

import com.emdata.ivvs.entity.Sbbhinfo;
import com.emdata.ivvs.entity.SbbhinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019/7/2.
 */
public interface SbbhinfoMapper {

    List<String> selectList(Map<String,Object> map);

}
