package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.api.goods.param.AppGetDataListParam;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.service.apiservice.APIDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * @create 2017-11-06 15:08
 **/

@RestController
@RequestMapping("/api/data")
@Api(value = "data", description = "产品相关接口")
public class APIDataResource {

    @Autowired
    private APIDataService apiDataService;

    @ApiOperation("获取产品详情")
    @RequestMapping(value = "/appGetProductDetailById",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "商品类型1为建材、2为服务", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "id", value = "商品id", required = true, paramType = "query", dataType = "Integer")
    })
    public ResponseEntity<Object> appGetProductDetailById(int type,int id){
        switch (type){
            case 1:
                return apiDataService.appGetGoodsDetailById(id);
            case 2:
                return apiDataService.appGetServiceDetailById(id);
                default:
                    return MyResponseUtil.error("参数不合法");
        }
    }

    @ApiOperation("获取产品列表")
    @RequestMapping(value = "/appGetProductList",method = RequestMethod.POST)
    public ResponseEntity<Object> appGetProductList(@RequestBody AppGetDataListParam param){
        switch (param.getType()){
            case 1:
                return apiDataService.appGetGoodsList(param);
            case 2:
                return apiDataService.appGetServiceList(param);
                default:
                    return MyResponseUtil.error("参数不合法");
        }
    }
}
