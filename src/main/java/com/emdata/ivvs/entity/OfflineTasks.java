package com.emdata.ivvs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2019/7/24.
 */
@Data
@Accessors(chain = true)
public class OfflineTasks implements Serializable {


    private static final long serialVersionUID = 4429304295186493149L;


    Long tid; //主键
    String taskName; //任务名称
    String taskFilePath; //文件路径
    String taskViolateType; //违法行为
    String remark; //备注

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date createAt; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date modifyAt; //更新时间
    String createMan; //创建人
    Integer isDel; //是否删除
    Integer taskStatus; //任务状态;1，正常；11，暂停；
    String taskAnalysis; //解析状态；默认为1,解析中；2，解析完成；3，解析失败；
    Integer taskAnalysisCount; //任务解析成功数量
    Integer taskAnalysisErrCount; //任务解析错误数量
    Integer taskAnalysisTotal; //任务解析总数
    String taskAnalysisState; //任务解析状态
    String taskAnalysisPercentage; //解析百分比


    String showTaskAnalysisViolate; //违法行为解析字符

}
