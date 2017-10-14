package com.glory.shenghuo.resource;

import com.glory.shenghuo.api.user.param.*;
import com.glory.shenghuo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource/user")
@Api(value = "user", description = "用户相关接口")
public class UserResource {


    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public ResponseEntity<Object> registerUser(@RequestBody UserRegisterParam param){
        return userService.registerUser(param);
    }

    @ApiOperation("用户登陆")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody UserLoginParam loginParam){
        return userService.login(loginParam);
    }

    @ApiOperation("修改手机号码")
    @RequestMapping(value = "/updateUserPhone",method = RequestMethod.POST)
    public ResponseEntity<Object> updateUserPhone(@RequestBody UpdatePhoneParam param){
        return userService.updateUserPhone(param);
    }

    @ApiOperation("修改用户姓名")
    @RequestMapping(value = "/updateUserName",method = RequestMethod.POST)
    public ResponseEntity<Object> updateUserName(@RequestBody UpdateNameParam param){
        return userService.updateUserName(param);
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updateUserPwd",method = RequestMethod.POST)
    public ResponseEntity<Object> updateUserPwd(@RequestBody UpdatePwdParam param){
        return userService.updateUserPwd(param);
    }
}
