package com.glory.shenghuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class TestController {

    @RequestMapping("/haha")
    public String test(){
        return "/producttype/product_type_list";
    }
}
