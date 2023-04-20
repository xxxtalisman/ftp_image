package com.emdata.ivvs.entity;

import com.google.common.base.Objects;
import lombok.Data;

import java.util.Date;

/**
 * Created on 2019/7/2.
 */
@Data
public class Sbbhinfo {
    private Integer sbid;

    private String sbbh;

    private String sbmc;

    private String sblx;

    private String sbzt;

    private String sbcx;

    private String wbdw;

    private String remark;

    private String zcode;

    private Date createTime;

    private Date updateTime;

    private Integer userid;

    private String accessState;

    private String auditStatus;

    private Integer uploadStatus;

    private Integer deployStatus;

    /**
     * 状态 1：正常 2：删除  3：禁用（切换城市时禁用原城市设备）
     */
    private Short status;

    private String gsdw;
    //附加信息
    /**
     * 路口编号
     */
    private String ccode;
    /**
     * 路口名称
     */
    private String cname;

    private String zname;



    /**
     * 设备预警推送状态：1-延时 2-实时
     */
    private Integer warningStatus;

    /**
     * 备案违法代码：多个以;隔开 如:1344;1345
     */
    private String receiveViolateCode;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sbbhinfo sbbhinfo = (Sbbhinfo) o;
        return Objects.equal(sbbh, sbbhinfo.sbbh);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sbbh);
    }

    @Override
    public String toString() {
        return "Sbbhinfo{" +
                "sbid=" + sbid +
                ", sbbh='" + sbbh + '\'' +
                ", sbmc='" + sbmc + '\'' +
                ", sblx='" + sblx + '\'' +
                ", sbzt='" + sbzt + '\'' +
                ", sbcx='" + sbcx + '\'' +
                ", wbdw='" + wbdw + '\'' +
                ", remark='" + remark + '\'' +
                ", zcode='" + zcode + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userid=" + userid +
                ", accessState='" + accessState + '\'' +
                ", auditStatus='" + auditStatus + '\'' +
                ", gsdw='" + gsdw + '\'' +
                '}';
    }
}
