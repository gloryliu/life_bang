package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.service.AppIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-02 14:06
 **/
@RestController
@RequestMapping("/resource/appIndex")
@Api(value = "appIndex", description = "APP首页接口")
public class APIAppIndexResource {

    @Autowired
    private AppIndexService appIndexService;

    @ApiOperation("获取首页和建材页面数据")
    @RequestMapping(value = "/getAppIndexData",method = RequestMethod.GET)
    @ApiImplicitParam(name = "type", value = "1为首页数据，2为建材页面数据", required = true, paramType = "query", dataType = "Integer")
    public ResponseEntity<Object> getAppIndexData(int type){
        switch (type){
            case 1:
                return appIndexService.getAppIndexData();
            case 2:
                return appIndexService.getAppJiancaiData();
                default:
                    return MyResponseUtil.error("参数不合法");
        }

    }
}
