package com.emdata.ivvs.entity;

import lombok.Data;

@Data
public class User {
  private Long userId;
  private String sobotId;
  private String userName;
  private String nickName;
  private String password;
  private String email;
  private Long unitId;
  private String mobile;
  private String userPic;
  private String ip;
  private java.sql.Timestamp lastLoginTime;
  private java.sql.Timestamp currentLoginTime;
  private Long state;
  private String group;
  private Long teamId;
  private java.sql.Timestamp createTime;
  private String createMan;
  private java.sql.Timestamp modifyTime;
  private String modifyMan;
  private String remark;
  private Long isLeave;
  private String idCard;
  private String wechat;
  private String rank;
  private java.sql.Timestamp lifeStart;
  private java.sql.Timestamp lifeEnd;

}
