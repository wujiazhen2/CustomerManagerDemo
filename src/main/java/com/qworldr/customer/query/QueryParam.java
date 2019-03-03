package com.qworldr.customer.query;


/**
 * Created by wujiazhen on 2018/4/2.
 */
public class QueryParam {

    private int pageSize;
    private int pageNum;
    private String searchText;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
