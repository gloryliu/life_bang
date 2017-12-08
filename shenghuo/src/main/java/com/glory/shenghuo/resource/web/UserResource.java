package com.glory.shenghuo.resource.web;

import com.glory.shenghuo.api.user.param.UserParam;
import com.glory.shenghuo.service.web.UserService;
import com.glory.shenghuo.util.PageInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/resource/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    public PageInfos getUserList(UserParam userParam){
        return userService.getUserList(userParam);
    }
}
