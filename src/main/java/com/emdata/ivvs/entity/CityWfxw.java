package com.emdata.ivvs.entity;

import java.util.Date;

/**
 * Created on 2019/7/2.
 */
public class CityWfxw {

    private Integer cvid;

    private Date createTime;

    private Date updateTime;

    private Integer userid;

    private String wfxw;

    // cityCode
    private String zcode;

    // 监控值
    private String cvmValue;

    // 状态,1启用,2禁用
    private Integer status;

    private String remark;

    public Integer getCvid() {
        return cvid;
    }

    public void setCvid(Integer cvid) {
        this.cvid = cvid;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getWfxw() {
        return wfxw;
    }

    public void setWfxw(String wfxw) {
        this.wfxw = wfxw == null ? null : wfxw.trim();
    }

    public String getZcode() {
        return zcode;
    }

    public void setZcode(String zcode) {
        this.zcode = zcode == null ? null : zcode.trim();
    }

    public String getCvmValue() {
        return cvmValue;
    }

    public void setCvmValue(String cvmValue) {
        this.cvmValue = cvmValue == null ? null : cvmValue.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "CityWfxw{" +
                "cvid=" + cvid +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userid=" + userid +
                ", wfxw='" + wfxw + '\'' +
                ", zcode='" + zcode + '\'' +
                ", cvmValue='" + cvmValue + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }
}
