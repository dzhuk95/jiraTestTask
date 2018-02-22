package com.zhuk95.little.jira.models.api.req;

public class GridReq {
    private int currentPage;
    private int limit;

    public GridReq() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
