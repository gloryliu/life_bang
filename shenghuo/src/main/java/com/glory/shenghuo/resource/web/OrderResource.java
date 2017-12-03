package com.glory.shenghuo.resource.web;

import com.glory.shenghuo.api.order.param.OrderListParam;
import com.glory.shenghuo.api.order.param.ProductOfOrderParam;
import com.glory.shenghuo.service.*;
import com.glory.shenghuo.util.PageInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/resource/order")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductOfOrderService productOfOrderService;

    @RequestMapping("/orderlist")
    public PageInfos getOrderList(OrderListParam orderListParam){
        return orderService.getOrderList(orderListParam);
    }
    @RequestMapping("/orderdetail")
    public PageInfos getOrderDetail(ProductOfOrderParam productOfOrderParam){
        return productOfOrderService.getAllProductByOrderId(productOfOrderParam);
    }
}
