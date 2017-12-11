package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.api.order.param.SubmitOrderParam;
import com.glory.shenghuo.service.apiservice.APIOrderService;
import io.swagger.annotations.Api;
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
}
