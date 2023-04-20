package com.emdata.ivvs.entity;

import java.util.Date;

/**
 * Created on 2019/7/2.
 */
public class Warning {
    private Integer id;

    private Date wardate;

    private String yesterdayPercent;

    private String nowPercent;

    private String contrastrate;

    private Integer isviolate;

    private Integer violatetype;

    private String vplacekakou;

    private String vplacecam;

    private String forecastvalues;

    private Date createTime;

    private String remark;

    private Integer forecastNumber;

    private String violatetypename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getWardate() {
        return wardate;
    }

    public void setWardate(Date wardate) {
        this.wardate = wardate;
    }

    public String getYesterdayPercent() {
        return yesterdayPercent;
    }

    public void setYesterdayPercent(String yesterdayPercent) {
        this.yesterdayPercent = yesterdayPercent == null ? null : yesterdayPercent.trim();
    }

    public String getNowPercent() {
        return nowPercent;
    }

    public void setNowPercent(String nowPercent) {
        this.nowPercent = nowPercent == null ? null : nowPercent.trim();
    }

    public String getContrastrate() {
        return contrastrate;
    }

    public void setContrastrate(String contrastrate) {
        this.contrastrate = contrastrate == null ? null : contrastrate.trim();
    }

    public Integer getIsviolate() {
        return isviolate;
    }

    public void setIsviolate(Integer isviolate) {
        this.isviolate = isviolate;
    }

    public Integer getViolatetype() {
        return violatetype;
    }

    public void setViolatetype(Integer violatetype) {
        this.violatetype = violatetype;
    }

    public String getVplacekakou() {
        return vplacekakou;
    }

    public void setVplacekakou(String vplacekakou) {
        this.vplacekakou = vplacekakou == null ? null : vplacekakou.trim();
    }

    public String getVplacecam() {
        return vplacecam;
    }

    public void setVplacecam(String vplacecam) {
        this.vplacecam = vplacecam == null ? null : vplacecam.trim();
    }

    public String getForecastvalues() {
        return forecastvalues;
    }

    public void setForecastvalues(String forecastvalues) {
        this.forecastvalues = forecastvalues == null ? null : forecastvalues.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getForecastNumber() {
        return forecastNumber;
    }

    public void setForecastNumber(Integer forecastNumber) {
        this.forecastNumber = forecastNumber;
    }

    public String getViolatetypename() {
        return violatetypename;
    }

    public void setViolatetypename(String violatetypename) {
        this.violatetypename = violatetypename == null ? null : violatetypename.trim();
    }
}
