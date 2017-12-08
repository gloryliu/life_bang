package com.glory.shenghuo.resource.appapi;

import com.aliyuncs.exceptions.ClientException;
import com.github.pagehelper.StringUtil;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.util.ALiYunSMSUtil;
import com.glory.shenghuo.util.ConstantUtils;
import com.glory.shenghuo.util.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-07-02 9:09
 **/
@RestController
@RequestMapping("/resource/sms")
@Api(value = "sms", description = "短信验证码")
public class APISMSResouce {

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getCheckCode",method = RequestMethod.GET)
    @ApiImplicitParam(name = "phone", value = "手机号码", required = true, paramType = "query", dataType = "String")
    public ResponseEntity<Object> getCheckCode(String phone, HttpServletRequest request){
        if(!StringUtil.isEmpty(phone)){
            String code = VerifyCodeUtils.generateVerifyCode(4);
            request.getSession().setAttribute(ConstantUtils.getCheckCodeName(phone),code);
            try {
                ALiYunSMSUtil.sendSms(phone,code);
            } catch (ClientException e) {
                e.printStackTrace();
                return MyResponseUtil.error("失败");
            }
            return MyResponseUtil.ok("成功");
        }else {
            return MyResponseUtil.error("手机号码为空");
        }
    }

    @ApiIgnore
    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
    public ResponseEntity<Object> getCode(String phone, HttpServletRequest request){
        String code = (String) request.getSession().getAttribute(ConstantUtils.getCheckCodeName(phone));
        return MyResponseUtil.ok(code);
    }
}
