package com.glory.shenghuo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-09 19:18
 **/
@ApiIgnore
@Controller
public class HaHaController {

    @RequestMapping("/")
    public String wanba(){
        return "haha/haha";
    }

}
