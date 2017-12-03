package com.glory.shenghuo.api.order.param;

import com.glory.shenghuo.api.order.pojo.ProductOfOrderPojo;

public class ProductOfOrderParam extends ProductOfOrderPojo{

    /**
     * 订单id
     */
    private int orderId;

    @Override
    public int getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

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
