package com.glory.shenghuo.mapper;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.glory.shenghuo.api.order.param.OrderListParam;
import com.glory.shenghuo.api.order.pojo.OrderPojo;

import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-07 16:53
 **/
public interface OrderMapper extends BaseMapper {

    /**
     * 添加订单
     * @param orderPojo
     * @return
     */
    int add(OrderPojo orderPojo);

    /**
     * 删除订单
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 获取订单详情
     * @param id
     * @return
     */
    OrderPojo getOrderDetail(int id);

    /**
     * 根据用户id获取订单列表
     * @param userId
     * @return
     */
    List<OrderPojo> getAllOrderByUserId(int userId);

    /**
     * 获取所有订单列表
     * @param orderListParam
     * @return
     */
    Page<OrderPojo> getOrderList(OrderListParam orderListParam);

    /**
     * 获取购买的所有服务列表
     * @param orderListParam
     * @return
     */
    Page<OrderPojo> getServiceOrderList(OrderListParam orderListParam);
}
