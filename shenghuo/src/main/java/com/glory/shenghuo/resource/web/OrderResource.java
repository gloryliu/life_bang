package com.glory.shenghuo.resource.web;

import com.glory.shenghuo.api.order.param.OrderListParam;
import com.glory.shenghuo.api.order.pojo.ProductOfOrderPojo;
import com.glory.shenghuo.service.web.OrderService;
import com.glory.shenghuo.service.web.ProductOfOrderService;
import com.glory.shenghuo.util.PageInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

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

    @RequestMapping("/getProductByOrderId")
    public List<ProductOfOrderPojo> getProductByOrderId(int orderId){
        return productOfOrderService.getAllProductByOrderId(orderId);
    }
}
