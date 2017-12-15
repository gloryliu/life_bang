package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.api.order.json.OrderDetailJson;
import com.glory.shenghuo.api.order.json.OrderListItemJson;
import com.glory.shenghuo.api.order.param.SubmitOrderListParam;
import com.glory.shenghuo.api.order.param.SubmitOrderParam;
import com.glory.shenghuo.common.BusinessException;
import com.glory.shenghuo.service.apiservice.APIOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-08 15:00
 **/

@RestController
@RequestMapping("/api/order")
@Api(value = "order", description = "订单相关接口")
public class APIOrderResource {

    @Autowired
    private APIOrderService apiOrderService;

    @ApiOperation("单品购买提交订单")
    @RequestMapping(value = "/submitOrder",method = RequestMethod.POST)
    public ResponseEntity<Object> submitOrder(@RequestBody SubmitOrderParam orderParam) throws Exception{
        return apiOrderService.addOrder(orderParam);
    }

    @ApiOperation("批量购买提交订单")
    @RequestMapping(value = "/submitOrderList",method = RequestMethod.POST)
    public ResponseEntity<Object> addOrderList(@RequestBody SubmitOrderListParam orderListParam) throws BusinessException {
        return apiOrderService.addOrderList(orderListParam);
    }

    @ApiOperation(value = "订单列表",response = OrderListItemJson.class)
    @RequestMapping(value = "/getOrderListByUserId",method = RequestMethod.GET)
    @ApiImplicitParam(name = "userId", value = "商品id", required = true, paramType = "query", dataType = "Integer")
    public ResponseEntity<Object> getOrderListByUserId(int userId){
        return apiOrderService.getOrderListByUserId(userId);
    }

    @ApiOperation(value = "订单详情",response = OrderDetailJson.class)
    @RequestMapping(value = "/getOrderDetail",method = RequestMethod.GET)
    @ApiImplicitParam(name = "orderId", value = "订单id", required = true, paramType = "query", dataType = "Integer")
    public ResponseEntity<Object> getOrderDetail(int orderId) throws BusinessException {
        return apiOrderService.getOrderDetail(orderId);
    }

    @ApiOperation(value = "取消订单",response = OrderDetailJson.class)
    @RequestMapping(value = "/cancleOrder",method = RequestMethod.GET)
    @ApiImplicitParam(name = "orderId", value = "订单id", required = true, paramType = "query", dataType = "Integer")
    public ResponseEntity<Object> cancleOrder(int orderId){
        return apiOrderService.cancleOrder(orderId);
    }
}
