package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.service.AppIndexService;
import io.swagger.annotations.Api;
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

    @RequestMapping(value = "/getAppIndexData",method = RequestMethod.GET)
    public ResponseEntity<Object> getAppIndexData(){
        return appIndexService.getAppIndexData();
    }
}
