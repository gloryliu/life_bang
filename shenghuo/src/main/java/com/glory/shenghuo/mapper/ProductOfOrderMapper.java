package com.glory.shenghuo.mapper;

import com.glory.shenghuo.api.order.pojo.ProductOfOrderPojo;

import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-07 16:40
 **/
public interface ProductOfOrderMapper extends BaseMapper{

    //向订单中添加产品
    int add(ProductOfOrderPojo productOfOrderPojo);

    //查询订单中的所有产品
    List<ProductOfOrderPojo> getAllProductByOrderId(int orderId);

    //删除订单中的所有产品
    int deleteProductByOrderId(int orderId);

}
