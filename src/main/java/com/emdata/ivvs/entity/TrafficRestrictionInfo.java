package com.emdata.ivvs.entity;

import lombok.Data;

/**
 * traffic_restriction_info实体类
 * 
 * @author 
 *
 */
@Data
public class TrafficRestrictionInfo {
	/***/
	private Long id; 
	/***/
	private String name; 
	/***/
	private String no; 
	/***/
	private Integer type; 
	/**关联规则图片*/
	private String pic; 
	/**
	 * 实例化
	 */
	public TrafficRestrictionInfo() {
		super();
	}

	
}
