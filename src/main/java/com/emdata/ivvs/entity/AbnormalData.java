package com.emdata.ivvs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 异常监控统计实体类
 */
public class AbnormalData extends AbnormalDataDetails{

    private Integer id;

    Long faultId;

    String causesAlarmName; //告警原因

    // 告警时间（第二天时间）
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date warnTime;

    // 波动率，如计算12.2日的违法波动率，绝对值：
    // （12.2日的违法总量  -  12.1日的违法总量）/12.1日的违法总量，保留至整数位。时间以违法时间为准。
    @JsonSerialize(using = RateJsonSerializer.class)    // 转换json格式化时，加%
    private BigDecimal changeRate;

    // 阈值
    @JsonSerialize(using = CvmJsonSerializer.class)    // 转换json格式化时，加%
    private String cvmValue;

    // 第一天的时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date firstDate;

    // 第一天的统计数
    private Integer firstCount;

    // 第二天的时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date secondDate;

    // 第二天的统计数
    private Integer secondCount;

    // 卡口记录id--该属性，设计中，已不需要，待删除
    @JsonIgnore
    private Integer checkPointId;

    // 卡口编号--该属性，设计中，已不需要，待删除
    @JsonIgnore
    private Integer cardno;

    // 卡口地址--该属性，设计中，已不需要，待删除
    @JsonIgnore
    private String address;

    // 设备编号记录id
    private Integer deviceId;

    // 设备编号（sbbh)
    private String shebeiCode;

    // 设备名称（sbmc)
    private String shebeiName;

    // 违法行为code（对应表ser_violation)
    private String algViolateCode;

    // 违法行为名称
    private String codeName;

    // 城市code
    private Integer cityCode;

    Integer disStatus; //派发状态


    public Long getFaultId() {
        return faultId;
    }

    public void setFaultId(Long faultId) {
        this.faultId = faultId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Integer getDisStatus() {
        return disStatus;
    }

    public void setDisStatus(Integer disStatus) {
        this.disStatus = disStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCausesAlarmName() {
        return causesAlarmName;
    }

    public void setCausesAlarmName(String causesAlarmName) {
        this.causesAlarmName = causesAlarmName;
    }

    public Date getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    public BigDecimal getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(BigDecimal changeRate) {
        this.changeRate = changeRate;
    }

    public String getCvmValue() {
        return cvmValue;
    }

    public void setCvmValue(String cvmValue) {
        this.cvmValue = cvmValue;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Integer getFirstCount() {
        return firstCount;
    }

    public void setFirstCount(Integer firstCount) {
        this.firstCount = firstCount;
    }

    public Date getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(Date secondDate) {
        this.secondDate = secondDate;
    }

    public Integer getSecondCount() {
        return secondCount;
    }

    public void setSecondCount(Integer secondCount) {
        this.secondCount = secondCount;
    }

    public Integer getCheckPointId() {
        return checkPointId;
    }

    public void setCheckPointId(Integer checkPointId) {
        this.checkPointId = checkPointId;
    }

    public Integer getCardno() {
        return cardno;
    }

    public void setCardno(Integer cardno) {
        this.cardno = cardno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getShebeiCode() {
        return shebeiCode;
    }

    public void setShebeiCode(String shebeiCode) {
        this.shebeiCode = shebeiCode == null ? null : shebeiCode.trim();
    }

    public String getShebeiName() {
        return shebeiName;
    }

    public void setShebeiName(String shebeiName) {
        this.shebeiName = shebeiName == null ? null : shebeiName.trim();
    }

    public String getAlgViolateCode() {
        return algViolateCode;
    }

    public void setAlgViolateCode(String algViolateCode) {
        this.algViolateCode = algViolateCode == null ? null : algViolateCode.trim();
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AbnormalData{" +
                "id=" + id +
                ", warnTime=" + warnTime +
                ", changeRate=" + changeRate +
                ", cvmValue='" + cvmValue + '\'' +
                ", firstDate=" + firstDate +
                ", firstCount=" + firstCount +
                ", secondDate=" + secondDate +
                ", secondCount=" + secondCount +
                ", checkPointId=" + checkPointId +
                ", cardno=" + cardno +
                ", address='" + address + '\'' +
                ", deviceId=" + deviceId +
                ", shebeiCode='" + shebeiCode + '\'' +
                ", shebeiName='" + shebeiName + '\'' +
                ", algViolateCode='" + algViolateCode + '\'' +
                ", codeName='" + codeName + '\'' +
                ", cityCode=" + cityCode +
                ", createTime=" + createTime +
                '}';
    }
}


class RateJsonSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provide)
            throws IOException, JsonProcessingException {
        jgen.writeString(value.toString() + "%");
    }
}

class CvmJsonSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator jgen, SerializerProvider provide)
            throws IOException, JsonProcessingException {
        jgen.writeString(value + "%");
    }
}