package com.emdata.ivvs.entity;

import lombok.Data;

@Data
public class Role {
  private Long roleId;
  private String roleName;
  private Long state;
  private java.sql.Timestamp createTime;
  private String createMan;
  private java.sql.Timestamp modifyTime;
  private String modifyMan;
  private String remark;

}
