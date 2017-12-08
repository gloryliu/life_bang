package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.api.collection.param.AddCollectionParam;
import com.glory.shenghuo.api.collection.pojo.CollectionPojo;
import com.glory.shenghuo.service.apiservice.APICollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * @create 2017-11-09 10:46
 **/
@RestController
@RequestMapping("/api/collection")
@Api(value = "collection", description = "收藏接口")
public class APICollectionResource {

    @Autowired
    private APICollectionService apiCollectionService;

    @ApiOperation("添加收藏")
    @RequestMapping(value = "/addCollection",method = RequestMethod.POST)
    public ResponseEntity<Object> addCollection(@RequestBody AddCollectionParam param){
        return apiCollectionService.addCollection(param);
    }

    @ApiOperation("删除收藏")
    @RequestMapping(value = "/deleteCollection",method = RequestMethod.GET)
    @ApiImplicitParam(name = "id", value = "收藏的id", required = true, paramType = "query", dataType = "Integer")
    public ResponseEntity<Object> deleteCollection(int id){
        return apiCollectionService.deleteCollection(id);
    }

    @ApiOperation(value = "获取所有收藏",response = CollectionPojo.class)
    @RequestMapping(value = "/getAllCollection",method = RequestMethod.GET)
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "Integer")
    public ResponseEntity<Object> getAllCollection(int userId){
        return apiCollectionService.getAllCollectionByUserId(userId);
    }
}
