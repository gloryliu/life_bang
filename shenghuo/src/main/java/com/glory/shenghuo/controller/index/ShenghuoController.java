package com.glory.shenghuo.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class ShenghuoController {

    @RequestMapping("/test")
    public String wanba(){
        return "index/index";
    }

}
