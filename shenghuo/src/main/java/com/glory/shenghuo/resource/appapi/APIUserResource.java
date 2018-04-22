package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.api.user.json.UserJson;
import com.glory.shenghuo.api.user.param.*;
import com.glory.shenghuo.service.apiservice.APIUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Api(value = "user", description = "用户相关接口")
public class APIUserResource {


    @Autowired
    private APIUserService apiUserService;

    @ApiOperation("用户注册")
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public ResponseEntity<Object> registerUser(@RequestBody UserRegisterParam param){
        return apiUserService.registerUser(param);
    }

    @ApiOperation(value = "用户登陆",response = UserJson.class)
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody UserLoginParam loginParam){
        return apiUserService.login(loginParam);
    }

    @ApiOperation("修改手机号码")
    @RequestMapping(value = "/updateUserPhone",method = RequestMethod.POST)
    public ResponseEntity<Object> updateUserPhone(@RequestBody UpdatePhoneParam param){
        return apiUserService.updateUserPhone(param);
    }

    @ApiOperation("修改用户姓名")
    @RequestMapping(value = "/updateUserName",method = RequestMethod.POST)
    public ResponseEntity<Object> updateUserName(@RequestBody UpdateNameParam param){
        return apiUserService.updateUserName(param);
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updateUserPwd",method = RequestMethod.POST)
    public ResponseEntity<Object> updateUserPwd(@RequestBody UpdatePwdParam param){
        return apiUserService.updateUserPwd(param);
    }

    @ApiOperation("修改头像")
    @RequestMapping(value = "/updateUserHeadImg",method = RequestMethod.POST)
    public ResponseEntity<Object> updateUserHeadImg(@RequestBody UpdateImgParam param){
        return apiUserService.updateUserHeadImg(param);
    }
}
