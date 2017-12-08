package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.api.serviceprovider.json.ServiceProvideJson;
import com.glory.shenghuo.api.serviceprovider.param.ServiceProviderParam;
import com.glory.shenghuo.api.serviceprovider.pojo.ServiceProviderPoJo;
import com.glory.shenghuo.common.BusinessException;
import com.glory.shenghuo.service.apiservice.APIServiceProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-07 20:16
 **/

@RestController
@RequestMapping("/api/provider")
@Api(value = "provider", description = "服务商相关接口")
public class APIProviderResource {

    @Autowired
    APIServiceProviderService apiServiceProviderService;

    @ApiOperation("添加服务商申请信息")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody ServiceProviderParam param) throws BusinessException {
        return apiServiceProviderService.add(param);
    }

    @ApiOperation(value = "获取服务商信息",response = ServiceProvideJson.class)
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/getProviderInfo",method = RequestMethod.GET)
    public ResponseEntity<Object> getProviderInfo(int userId){
        return apiServiceProviderService.getProviderInfo(userId);
    }
}
