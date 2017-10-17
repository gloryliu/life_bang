package com.glory.shenghuo.resource;

import com.glory.shenghuo.api.producttype.pojo.ProductTypePoJo;
import com.glory.shenghuo.common.MyResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/resource/productType")
public class ProductTypeResource {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<Object> getTypeList(){
        ArrayList<ProductTypePoJo> list = new ArrayList<>();
        ArrayList<ProductTypePoJo> menulist = new ArrayList<>();
        ProductTypePoJo menu1 = new ProductTypePoJo();
        menu1.setId(2);
        menu1.setText("哈哈哈");
        menu1.setParentId(1);

        ProductTypePoJo menu2 = new ProductTypePoJo();
        menu2.setId(3);
        menu2.setText("哥哥哥");
        menu2.setParentId(1);

        list.add(menu1);
        list.add(menu2);

        ProductTypePoJo menu = new ProductTypePoJo();
        menu.setId(1);
        menu.setText("一级菜单");
        menu.setParentId(0);
        menu.setChildren(list);

        ProductTypePoJo menu11 = new ProductTypePoJo();
        menu11.setId(1);
        menu11.setText("一级菜单");
        menu11.setParentId(0);
        menu11.setChildren(list);

        ProductTypePoJo menu22 = new ProductTypePoJo();
        menu22.setId(4);
        menu22.setText("一级菜单");
        menu22.setParentId(0);
        menu22.setChildren(list);

        ProductTypePoJo menu33 = new ProductTypePoJo();
        menu33.setId(5);
        menu33.setText("一级菜单");
        menu33.setParentId(0);
        menu33.setChildren(list);

        menulist.add(menu);
        menulist.add(menu11);
        menulist.add(menu22);
        menulist.add(menu33);

        return new ResponseEntity<Object>(menulist, HttpStatus.OK);
    }
}
