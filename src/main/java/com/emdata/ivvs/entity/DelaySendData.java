package com.emdata.ivvs.entity;

import lombok.Data;

/**
 * Created on 2019/7/18.
 */
@Data
public class DelaySendData {

    Integer did;
    Long source_data_id;
    Long processed_data_id;
    Integer is_send;
    String create_at;
    String send_at;
    Long delay_times;


    //处理copy为发送实体对象值属性
    String processedDataId; //
    String sourceDataId; //当条input data_id
    String margeStatus;
}
