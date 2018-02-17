package com.zhuk95.little.jira.models.api.resp;

import java.util.List;

public class ListResp {
    private long totalCount;
    private List<?> list;

    public ListResp(long totalCount, List<?> list) {
        this.totalCount = totalCount;
        this.list = list;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
