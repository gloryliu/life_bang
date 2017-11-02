package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.service.ProductTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/api/productType")
@Api(value = "productType", description = "产品分类列表")
public class APIProductTypeResource {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<Object> getTypeList(){
        return productTypeService.getTypeList();
    }
}
