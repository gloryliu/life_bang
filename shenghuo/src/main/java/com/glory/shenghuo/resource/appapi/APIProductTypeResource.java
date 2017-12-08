package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.api.producttype.pojo.ProductTypePoJo;
import com.glory.shenghuo.service.apiservice.APIProductTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/productType")
@Api(value = "productType", description = "产品分类列表")
public class APIProductTypeResource {

    @Autowired
    APIProductTypeService apiProductTypeService;

//    @Autowired
//    private ProductTypeService productTypeService;
//
//    @RequestMapping(value = "/list",method = RequestMethod.GET)
//    public ResponseEntity<Object> getTypeList(){
//        return productTypeService.getTypeList();
//    }


    /**
     * 根据父id和类型获取产品类型
     * @param parentId
     * @param type
     * @return
     */
    @ApiOperation(value = "获取产品类型",response = ProductTypePoJo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父id顶级的父id为0", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "type", value = "1为建材2为服务", required = true, paramType = "path", dataType = "Integer")
    })
    @RequestMapping(value = "/getProductClassify/{parentId}/{type}",method = RequestMethod.GET)
    public ResponseEntity<Object> getProductClassify(@PathVariable int parentId, @PathVariable int type){
        return apiProductTypeService.getProductClassify(parentId,type);
    }
}
