package com.glory.shenghuo.controller.admin;

import com.glory.shenghuo.api.order.pojo.OrderPojo;
import com.glory.shenghuo.api.user.pojo.UserPoJo;
import com.glory.shenghuo.service.web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/controller/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @Autowired
    private UserService userService;


    @RequestMapping("/list")
    public String getOrderList(){
        return "admin/order/order_list";
    }

    @RequestMapping("/detail")
    public String getOrderDetail(ModelMap modelMap, Integer orderId){
        //根据订单id查询出订单详情
        OrderPojo orderPojo = orderService.getOrderDetail(orderId);
        modelMap.put("orderPojo",orderPojo);
        //查询该订单的下单用户信息
        UserPoJo userPoJo = null;
        userPoJo = userService.getUserInfoById(orderPojo.getUserId());
        modelMap.put("userName", userPoJo.getUserName());//订单用户

        modelMap.put("orderId",orderId);

        return "admin/order/order_detail";
    }

    /**
     * 获取购买的所有服务的列表
     * @return
     */
    @RequestMapping("/serviceOrderList")
    public String getServiceOrderList(){
        return "admin/order/serviceorder_list";
    }
}
