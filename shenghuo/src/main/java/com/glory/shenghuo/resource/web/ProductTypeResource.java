package com.glory.shenghuo.resource.web;

import com.glory.shenghuo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/resource/productType")
public class ProductTypeResource {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<Object> getTypeList(){
        return productTypeService.getTypeList();
    }

    /**
     * 获取建材的所有分类
     * @return
     */
    @RequestMapping(value = "/getSelectDomListOfGoods",method = RequestMethod.GET)
    public String getSelectDomListOfGoods(){
        return productTypeService.getSelectDomList(1);
    }

    /**
     * 获取服务的所有分类
     * @return
     */
    @RequestMapping(value = "/getSelectDomListOfService",method = RequestMethod.GET)
    public String getSelectDomListOfService(){
        return productTypeService.getSelectDomList(2);
    }
}
