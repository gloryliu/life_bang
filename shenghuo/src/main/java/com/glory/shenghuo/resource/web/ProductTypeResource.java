package com.glory.shenghuo.resource.web;

import com.glory.shenghuo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource/productType")
public class ProductTypeResource {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<Object> getTypeList(){
        return productTypeService.getTypeList();
    }

    @RequestMapping(value = "/getSelectDomList",method = RequestMethod.GET)
    public String getSelectDomList(){
        return productTypeService.getSelectDomList();
    }
}
