package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.api.cart.param.AddCartParam;
import com.glory.shenghuo.service.apiservice.APICartService;
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
 * @create 2017-11-06 18:03
 **/
@RestController
@RequestMapping("/api/cart")
@Api(value = "cart", description = "购物车")
public class APICartResource {

    @Autowired
    private APICartService cartService;

    @ApiOperation("获取购物车列表")
    @RequestMapping(value = "/getCartList",method = RequestMethod.GET)
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "Integer")
    public ResponseEntity<Object> getCartList(int userId){
        return cartService.getCartList(userId);
    }

    @ApiOperation("添加购物车")
    @RequestMapping(value = "/addCart",method = RequestMethod.POST)
    public ResponseEntity<Object> addCart(@RequestBody  AddCartParam param){
        return cartService.addCart(param);
    }

    @ApiOperation("获取产品详情")
    @RequestMapping(value = "/deleteCart",method = RequestMethod.GET)
    @ApiImplicitParam(name = "id", value = "购物车id", required = true, paramType = "query", dataType = "Integer")
    public ResponseEntity<Object> deleteCart(int id){
        return cartService.deleteCart(id);
    }
}
