package com.kylin.recyclerviewdemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kylin on 2016/3/18.
 * <p/>
 * "PageIndex": 1,
 * "PageSize": 20,
 * "TotalCount": 16367,
 * "TotalPage": 819
 */
public class ParamzBean implements Serializable {

    private List<FeedsBean> feeds;

    private String PageIndex;
    private String PageSize;
    private String TotalCount;
    private String TotalPage;

    public List<FeedsBean> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedsBean> feeds) {
        this.feeds = feeds;
    }

    public String getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(String pageIndex) {
        PageIndex = pageIndex;
    }

    public String getPageSize() {
        return PageSize;
    }

    public void setPageSize(String pageSize) {
        PageSize = pageSize;
    }

    public String getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(String totalCount) {
        TotalCount = totalCount;
    }

    public String getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(String totalPage) {
        TotalPage = totalPage;
    }

    @Override
    public String toString() {
        return "ParamzBean{" +
                "feeds=" + feeds +
                ", PageIndex='" + PageIndex + '\'' +
                ", PageSize='" + PageSize + '\'' +
                ", TotalCount='" + TotalCount + '\'' +
                ", TotalPage='" + TotalPage + '\'' +
                '}';
    }
}
