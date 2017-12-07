package com.glory.shenghuo.api.serviceprovider.param;

import com.glory.shenghuo.api.serviceprovider.pojo.ServiceProviderPoJo;

public class ServiceProviderListParam extends ServiceProviderPoJo {
    /**
     * 当前页
     */
    private int pageNum;

    /**
     * 每页条数
     */
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
