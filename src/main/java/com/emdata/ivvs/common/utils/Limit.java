package com.emdata.ivvs.common.utils;

import io.swagger.annotations.ApiModelProperty;

public class Limit {

    @ApiModelProperty(value = "页大小")
    private int start = 0;

    @ApiModelProperty(value = "分页条数")
    private int maxRows = -1;

    public Limit() {}

    public Limit(int start) {
        this.start = start;
    }

    public Limit(int start, int maxRows) {
        this.start = start;
        this.maxRows = maxRows;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
    }
}
