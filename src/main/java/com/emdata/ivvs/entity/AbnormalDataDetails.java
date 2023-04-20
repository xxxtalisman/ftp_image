package com.emdata.ivvs.entity;

import lombok.Data;

import java.util.List;

/**
 * Created on 2019/7/23.
 */
@Data
public class AbnormalDataDetails {

    String scenePic; //场景图片

    List<AbnormalDataDetailsDays> abnormalDataDetailsDaysList;

}
