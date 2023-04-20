package com.emdata.ivvs.entity;

/**
 * Created on 2019/7/11.
 * 全国车辆牌照配置的实体类
 */
public class TrafficPlate {
    private Integer id;

    // 省份
    private String province;

    // 牌照区域字母
    private String cityLetter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCityLetter() {
        return cityLetter;
    }

    public void setCityLetter(String cityLetter) {
        this.cityLetter = cityLetter == null ? null : cityLetter.trim();
    }

    @Override
    public String toString() {
        return "TrafficPlateController{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", cityLetter='" + cityLetter + '\'' +
                '}';
    }
}
