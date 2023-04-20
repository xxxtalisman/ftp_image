package com.emdata.ivvs.entity;

import com.alibaba.fastjson.JSONArray;

import java.util.Date;

/**
 * 违法行为-算法配置实体类
 */
public class AlgIllegalConfig {

    private Integer id;

    // 配置的算法类型的类型
    private Integer algIllegalType;

    // 算法类型名称
    private String algIllegalName;

    // 配置项的key（）
    private String configKey;

    // 配置项key对应的名称（如：配置地面标线）
    private String configName;

    // 配置项的类型，单选：radio，多选：checkbox
    private String configType;

    // 配置项开关默认值（0：否，1：是）
    private String onOffDefault;

    // 选择的开关值（0：否，1：是）
    private String onOffSelect;

    // 配置项的可选项的集合（格式为：[{"id": '1', "value": "有效"}]）
    private JSONArray optionValue;

    // 默认的选项集合（格式为：[{"id": '1', "value": "疑似"}]）
    private JSONArray optionDefault;

    // 选择的选项集合（格式为：[{"id": '1', "value": "疑似"}]）
    private JSONArray optionSelect;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlgIllegalType() {
        return algIllegalType;
    }

    public void setAlgIllegalType(Integer algIllegalType) {
        this.algIllegalType = algIllegalType;
    }

    public String getAlgIllegalName() {
        return algIllegalName;
    }

    public void setAlgIllegalName(String algIllegalName) {
        this.algIllegalName = algIllegalName;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey == null ? null : configKey.trim();
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType == null ? null : configType.trim();
    }

    public String getOnOffDefault() {
        return onOffDefault;
    }

    public void setOnOffDefault(String onOffDefault) {
        this.onOffDefault = onOffDefault == null ? null : onOffDefault.trim();
    }

    public String getOnOffSelect() {
        return onOffSelect;
    }

    public void setOnOffSelect(String onOffSelect) {
        this.onOffSelect = onOffSelect == null ? null : onOffSelect.trim();
    }

    public JSONArray getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(JSONArray optionValue) {
        this.optionValue = optionValue;
    }

    public JSONArray getOptionDefault() {
        return optionDefault;
    }

    public void setOptionDefault(JSONArray optionDefault) {
        this.optionDefault = optionDefault;
    }

    public JSONArray getOptionSelect() {
        return optionSelect;
    }

    public void setOptionSelect(JSONArray optionSelect) {
        this.optionSelect = optionSelect;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AlgIllegalConfig{" +
                "id=" + id +
                ", algIllegalType=" + algIllegalType +
                ", algIllegalName='" + algIllegalName + '\'' +
                ", configKey='" + configKey + '\'' +
                ", configName='" + configName + '\'' +
                ", configType='" + configType + '\'' +
                ", onOffDefault='" + onOffDefault + '\'' +
                ", onOffSelect='" + onOffSelect + '\'' +
                ", optionValue=" + optionValue +
                ", optionDefault=" + optionDefault +
                ", optionSelect=" + optionSelect +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}