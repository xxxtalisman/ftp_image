package com.emdata.ivvs.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Author: txw
 * @Date: 2020/4/16 17:06
 */
@Mapper
public interface PutDataDao {

    /**
     * 根据设备编号sbbh获取卡口信息
     * @param mapsParams
     * @return
     */
    Map<String,Object> selectPdaCardMouthByDevice(Map<String,Object> mapsParams);
}
