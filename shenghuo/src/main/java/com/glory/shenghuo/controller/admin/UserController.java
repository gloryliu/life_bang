package com.glory.shenghuo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-21 21:06
 **/
@ApiIgnore
@Controller
@RequestMapping("/controller/user")
public class UserController {

    @RequestMapping("/userList")
    public String userList(){
        return "user/user_list";
    }

    @RequestMapping("/detail")
    public String detail(ModelMap map, Integer userId){
        if (userId != null && userId != 0){
            map.put("userId",userId);
        }
        return "user/user_detail";
    }
}
