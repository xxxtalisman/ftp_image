package com.emdata.ivvs.model.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class PagerManager implements Serializable {

    private static final long serialVersionUID = -986418271892206627L;

    @ApiModelProperty(value = "当前页码,默认为1")
    private int page = 1;

    @ApiModelProperty(value = "当前页条数,默认为20")
    private int pageSize = 20;

    @ApiModelProperty(hidden = true)
    private int totalResults = 0;

    @ApiModelProperty(hidden = true)
    public static int MAX_RESULT = 20;

    @ApiModelProperty(hidden = true)
    public int LAST_RESULT = 20;

    @ApiModelProperty(hidden = true)
    private int start = 0;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public PagerManager() {

    }

    public PagerManager(int page, int pageSize) {
        super();
        page = page <= 0 ? 1 : page;
        this.page = page;
        this.pageSize = pageSize;
    }

    public PagerManager(int page, int pageSize, int totalResults) {

        super();
        page = page <= 0 ? 1 : page;
        this.page = page;
        this.pageSize = pageSize;
        this.totalResults = totalResults;
    }

    /**
     * 返回总页数
     * 
     * @return
     */
    @ApiModelProperty(hidden = true)
    public int getTotalPage() {
        if (0 == pageSize) {
            return 0;
        }
        return totalResults % pageSize == 0 ? totalResults / pageSize : totalResults / pageSize + 1;
    }

    @ApiModelProperty(hidden = true)
    public boolean isHasPre() {
        return page > 1;
    }

    @ApiModelProperty(hidden = true)
    public boolean isHasNext() {
        return getTotalPage() > page;
    }

    /**
     * 第一个结果
     * 
     * @return
     */
    @ApiModelProperty(hidden = true)
    public int getFirstResult() {
        return (page - 1) * pageSize;
    }

    /**
     * 最后结果
     * 
     * @return
     */
    @ApiModelProperty(hidden = true)
    public int getMaxResult() {
        return pageSize;
    }

    /**
     * 最后结果的数据
     * 
     * @return
     */
    @ApiModelProperty(hidden = true)
    public int getLastResult() {
        return page * pageSize;
    }

    public int getpage() {
        return page;
    }

    public void setpage(int page) {
        if (0 >= page) {
            page = 1;
        }
        this.page = page;
    }

    public int getpageSize() {
        return pageSize;
    }

    public void setpageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int gettotalResults() {
        return totalResults;
    }

    public void settotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

}
