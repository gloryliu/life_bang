package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.service.apiservice.APIGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goods")
@Api(value = "goods", description = "商品相关接口")
public class APIGoodsResource {

    @Autowired
    private APIGoodsService apiGoodsService;

    @RequestMapping(value = "/appGetGoodsDetailById",method = RequestMethod.GET)
    @ApiImplicitParam(name = "id", value = "商品id", required = true, paramType = "query", dataType = "Integer")
    public ResponseEntity<Object> appGetGoodsDetailById(int id){
        return apiGoodsService.appGetGoodsDetailById(id);
    }
}
