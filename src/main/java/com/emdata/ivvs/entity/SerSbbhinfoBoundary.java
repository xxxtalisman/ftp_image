package com.emdata.ivvs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */

public class SerSbbhinfoBoundary implements Serializable {
    /**
     * 主键id自增
     */
    private Integer sbid;

    /**
     * 设备编号
     */
    private String sbbh;

    /**
     * 设备名称
     */
    private String sbmc;

    /**
     * 设备类型1卡口，2电子警察，3监控，4其他
     */
    private String sblx;

    /**
     * 设备状态1正常，2故障，3维修中
     */
    private String sbzt;

    /**
     * 设备朝向
     */
    private String sbcx;

    /**
     * 维保单位
     */
    private String wbdw;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据权限表（cityinfo），zcode
     */
    private String zcode;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 修改日期
     */
    private Date updateTime;

    /**
     * user表id(创建人)
     */
    private Integer userid;

    /**
     * 违法数据接入，1启用，2禁用
     */
    private String accessState;

    /**
     * 智能审核状态 1启用，2禁用
     */
    private String auditStatus;

    /**
     * 审核上传状态 1启用 2禁用
     */
    private Short uploadStatus;

    /**
     * 状态 1：正常 2：失效
     */
    private Short status;

    /**
     * 归属单位
     */
    private String gsdw;

    private static final long serialVersionUID = 1L;

    public Integer getSbid() {
        return sbid;
    }

    public void setSbid(Integer sbid) {
        this.sbid = sbid;
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh;
    }

    public String getSbmc() {
        return sbmc;
    }

    public void setSbmc(String sbmc) {
        this.sbmc = sbmc;
    }

    public String getSblx() {
        return sblx;
    }

    public void setSblx(String sblx) {
        this.sblx = sblx;
    }

    public String getSbzt() {
        return sbzt;
    }

    public void setSbzt(String sbzt) {
        this.sbzt = sbzt;
    }

    public String getSbcx() {
        return sbcx;
    }

    public void setSbcx(String sbcx) {
        this.sbcx = sbcx;
    }

    public String getWbdw() {
        return wbdw;
    }

    public void setWbdw(String wbdw) {
        this.wbdw = wbdw;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getZcode() {
        return zcode;
    }

    public void setZcode(String zcode) {
        this.zcode = zcode;
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

    public String getAccessState() {
        return accessState;
    }

    public void setAccessState(String accessState) {
        this.accessState = accessState;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Short getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Short uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getGsdw() {
        return gsdw;
    }

    public void setGsdw(String gsdw) {
        this.gsdw = gsdw;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SerSbbhinfoBoundary other = (SerSbbhinfoBoundary) that;
        return (this.getSbid() == null ? other.getSbid() == null : this.getSbid().equals(other.getSbid()))
                && (this.getSbbh() == null ? other.getSbbh() == null : this.getSbbh().equals(other.getSbbh()))
                && (this.getSbmc() == null ? other.getSbmc() == null : this.getSbmc().equals(other.getSbmc()))
                && (this.getSblx() == null ? other.getSblx() == null : this.getSblx().equals(other.getSblx()))
                && (this.getSbzt() == null ? other.getSbzt() == null : this.getSbzt().equals(other.getSbzt()))
                && (this.getSbcx() == null ? other.getSbcx() == null : this.getSbcx().equals(other.getSbcx()))
                && (this.getWbdw() == null ? other.getWbdw() == null : this.getWbdw().equals(other.getWbdw()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getZcode() == null ? other.getZcode() == null : this.getZcode().equals(other.getZcode()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
                && (this.getAccessState() == null ? other.getAccessState() == null : this.getAccessState().equals(other.getAccessState()))
                && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
                && (this.getUploadStatus() == null ? other.getUploadStatus() == null : this.getUploadStatus().equals(other.getUploadStatus()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getGsdw() == null ? other.getGsdw() == null : this.getGsdw().equals(other.getGsdw()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSbid() == null) ? 0 : getSbid().hashCode());
        result = prime * result + ((getSbbh() == null) ? 0 : getSbbh().hashCode());
        result = prime * result + ((getSbmc() == null) ? 0 : getSbmc().hashCode());
        result = prime * result + ((getSblx() == null) ? 0 : getSblx().hashCode());
        result = prime * result + ((getSbzt() == null) ? 0 : getSbzt().hashCode());
        result = prime * result + ((getSbcx() == null) ? 0 : getSbcx().hashCode());
        result = prime * result + ((getWbdw() == null) ? 0 : getWbdw().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getZcode() == null) ? 0 : getZcode().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getAccessState() == null) ? 0 : getAccessState().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getUploadStatus() == null) ? 0 : getUploadStatus().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getGsdw() == null) ? 0 : getGsdw().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sbid=").append(sbid);
        sb.append(", sbbh=").append(sbbh);
        sb.append(", sbmc=").append(sbmc);
        sb.append(", sblx=").append(sblx);
        sb.append(", sbzt=").append(sbzt);
        sb.append(", sbcx=").append(sbcx);
        sb.append(", wbdw=").append(wbdw);
        sb.append(", remark=").append(remark);
        sb.append(", zcode=").append(zcode);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", userid=").append(userid);
        sb.append(", accessState=").append(accessState);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", uploadStatus=").append(uploadStatus);
        sb.append(", status=").append(status);
        sb.append(", gsdw=").append(gsdw);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}