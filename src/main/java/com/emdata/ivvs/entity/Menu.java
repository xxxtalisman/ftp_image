package com.emdata.ivvs.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Menu {
  private Long menuId;
  private String menuName;
  private Long parentId;
  private String icon;
  private String url;
  private Long state;
  private Long level;
  private Date createTime;
  private String createMan;
  private Date modifyTime;
  private String modifyMan;
  private String remark;
  private Long orderNumber;
  private String activeIcon;

}
