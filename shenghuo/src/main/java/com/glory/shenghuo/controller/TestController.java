package com.glory.shenghuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/haha")
    public String test(){
        return "/producttype/product_type_list";
    }
}
