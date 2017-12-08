package com.glory.shenghuo.service.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glory.shenghuo.api.order.param.ProductOfOrderParam;
import com.glory.shenghuo.api.order.pojo.OrderPojo;
import com.glory.shenghuo.api.order.param.OrderListParam;
import com.glory.shenghuo.mapper.OrderMapper;
import com.glory.shenghuo.util.PageInfos;
import com.glory.shenghuo.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    /**
     * 订单操作
     */
    @Autowired
    private OrderMapper orderMapper;

    //获取所有订单列表
    public PageInfos getOrderList(OrderListParam orderListParam){
        PageHelper.startPage(orderListParam.getPageNum(),orderListParam.getPageSize(),true);
        Page<OrderPojo> orderPojos = orderMapper.getOrderList(orderListParam);
        PageInfo<OrderPojo> data = new PageInfo<>(orderPojos);
        return UtilTools.pageChange(data,orderPojos);
    }

    //根据orderid查询订单信息（姓名、电话、地址等）
    public OrderPojo getOrderDetail(Integer orderId){
        return orderMapper.getOrderDetail(orderId);
    }
}
