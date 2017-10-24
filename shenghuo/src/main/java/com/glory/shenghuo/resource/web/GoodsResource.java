package com.glory.shenghuo.resource.web;

import com.glory.shenghuo.api.goods.param.GoodsInsertParam;
import com.glory.shenghuo.api.goods.param.GoodsListParam;
import com.glory.shenghuo.service.GoodsService;
import com.glory.shenghuo.util.PageInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/resource/goods")
public class GoodsResource {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert( GoodsInsertParam goodsParam){
        return goodsService.insert(goodsParam);
    }

    @RequestMapping(value = "/getAllList",method = RequestMethod.POST)
    public PageInfos getAllList(GoodsListParam goodsListParam){
        return goodsService.getAllList(goodsListParam);
    }
}