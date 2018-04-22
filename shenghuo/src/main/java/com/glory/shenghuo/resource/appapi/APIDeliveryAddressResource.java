package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.api.deliveryaddress.param.DeliveryAddressParam;
import com.glory.shenghuo.api.deliveryaddress.pojo.DeliveryAddressPojo;
import com.glory.shenghuo.service.web.DeliveryAddressService;
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
 * @create 2017-06-21 21:20
 **/
@RestController
@RequestMapping("/api/deliveryAddress")
@Api(value = "address", description = "用户收货地址接口")
public class APIDeliveryAddressResource {

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    /**
     * 添加收货地址
     * @param param
     * @return
     */
    @ApiOperation("添加地址")
    @RequestMapping(value = "/addAddress",method = RequestMethod.POST)
    public ResponseEntity<Object> addAddress(@RequestBody DeliveryAddressParam param){
        return deliveryAddressService.insert(param);
    }

    /**
     * 跟进userId获取所有收货地址
     * @param userid
     * @return
     */
    @ApiOperation(value = "根据userId获取列表",response = DeliveryAddressPojo.class)
    @RequestMapping(value = "/getAllDeliveryAddress",method = RequestMethod.GET)
    @ApiImplicitParam(name = "userid", value = "用户id", required = true, paramType = "query", dataType = "int")
    public ResponseEntity<Object> getAllListByUserid(int userid){
        return deliveryAddressService.appGetAllListByUserid(userid);
    }

    /**
     * 编辑收货地址
     * @param deliveryAddressPojo
     * @return
     */
    @ApiOperation("编辑地址")
    @RequestMapping(value = "/updateDeliveryAddress",method = RequestMethod.POST)
    public ResponseEntity<Object> updateDeliveryAddress(@RequestBody DeliveryAddressPojo deliveryAddressPojo){
        return deliveryAddressService.update(deliveryAddressPojo);
    }

    /**
     * 删除收货地址
     * @param id
     * @return
     */
    @ApiOperation("删除地址")
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    @ApiImplicitParam(name = "id", value = "地址id", required = true, paramType = "query", dataType = "int")
    public ResponseEntity<Object> delete(int id){
        return deliveryAddressService.deleteById(id);
    }
}
