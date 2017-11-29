package com.glory.shenghuo.mapper;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.github.pagehelper.Page;
//import com.glory.shenghuo.api.order.param.OrderListParam;
import com.glory.shenghuo.api.order.pojo.OrderPojo;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-07 16:53
 **/
public interface OrderMapper extends BaseMapper {

    //添加订单
    int add(OrderPojo orderPojo);

    //删除订单
    int delete(int id);

    //获取订单详情
    OrderPojo getOrderDetail(int id);

    //根据用户id获取订单列表
    Page<OrderPojo> getAllOrderByUserId(int userId);

    //获取所有订单列表
    //Page<OrderPojo> getOrderList(OrderListParam orderListParam);
}
