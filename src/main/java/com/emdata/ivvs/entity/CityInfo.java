package com.emdata.ivvs.entity;

import java.util.Date;

/**
 * Created on 2019/7/2.
 */
public class CityInfo {

    private Integer zid;

    private String zcode;

    private String zname;

    private String zparentcode;

    private Date createtime;

    private String remark;

    private Integer state;

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public String getZcode() {
        return zcode;
    }

    public void setZcode(String zcode) {
        this.zcode = zcode == null ? null : zcode.trim();
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname == null ? null : zname.trim();
    }

    public String getZparentcode() {
        return zparentcode;
    }

    public void setZparentcode(String zparentcode) {
        this.zparentcode = zparentcode == null ? null : zparentcode.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
