package com.emdata.ivvs.entity;

import lombok.Data;

/**
 * Created on 2019/7/15.
 */
@Data
public class ProcessedDataJoinSourceData {

    long sourceDataId;
    long processedDataId;
    String wfxw;
    Integer margeViolateType;
    Integer deviceId;
}
