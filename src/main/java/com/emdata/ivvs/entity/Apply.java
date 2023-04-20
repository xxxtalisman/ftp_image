package com.emdata.ivvs.entity;

import java.util.Date;

/**
 * Created on 2019/7/2.
 */
public class Apply {
    private Integer aid;

    private Integer applyuserid;

    private Integer applynumber;

    private Integer applytype;

    private Date applydate;

    private Date createTime;

    private String remark;

    private Integer applyisviolate;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getApplyuserid() {
        return applyuserid;
    }

    public void setApplyuserid(Integer applyuserid) {
        this.applyuserid = applyuserid;
    }

    public Integer getApplynumber() {
        return applynumber;
    }

    public void setApplynumber(Integer applynumber) {
        this.applynumber = applynumber;
    }

    public Integer getApplytype() {
        return applytype;
    }

    public void setApplytype(Integer applytype) {
        this.applytype = applytype;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
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

    public Integer getApplyisviolate() {
        return applyisviolate;
    }

    public void setApplyisviolate(Integer applyisviolate) {
        this.applyisviolate = applyisviolate;
    }
}
