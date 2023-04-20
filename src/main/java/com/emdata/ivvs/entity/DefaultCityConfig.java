package com.emdata.ivvs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created on 2019/6/28.
 */
@Data
@ApiModel(value = "city参数对象")
public class DefaultCityConfig {
    String uuid; //主键自增长

    @ApiModelProperty(value="省份代码",required=true)
    String province;
    @ApiModelProperty(value="省份名称",required=true)
    String provinceName; //省

    @ApiModelProperty(value="城市代码",required=true)
    String city;
    @ApiModelProperty(value="城市名称",required=true)
    String cityName; //市

    @ApiModelProperty(value="区县代码")
    String district;
    @ApiModelProperty(value="区县名称")
    String districtName; //区县

    @ApiModelProperty(value="项目标题名称")
    String projectName; //网页标题,

    @ApiModelProperty(value="批量开关按钮(0,关1,开)",hidden = true)
    Boolean onOroff; //批量开关按钮(0,关1,开)

    @ApiModelProperty(value="放大效果;0为跟随放大；1为固定放大",hidden = true)
    Integer magnified; //放大效果;0为跟随放大；1为固定放大

    @ApiModelProperty(value="数据申请开关;默认0为禁用；1，启用",hidden = true)
    Boolean applyOff; //数据申请开关;默认0为禁用；1，启用

    @ApiModelProperty(value="数据提交,默认0,全部；2，违法+疑似；1，违法",hidden = true)
    Integer submission; //数据提交,默认0,全部；2，违法+疑似；1，违法

    @ApiModelProperty(value="当前城市代码编号",hidden = true)
    String currentCity; //code

    @ApiModelProperty(value="提示语时长",required = true)
    Integer tipLength;

    @ApiModelProperty(value="车辆信息六合一调用开关，默认1，启用；0，禁用",required = true)
    Boolean sixInOneOff;
}
