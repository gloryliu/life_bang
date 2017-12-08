package com.glory.shenghuo.resource.web;

import com.glory.shenghuo.api.goods.param.ChangeRecGoodsStateParam;
import com.glory.shenghuo.api.goods.param.GoodsInsertParam;
import com.glory.shenghuo.api.goods.param.GoodsListParam;
import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.service.web.GoodsService;
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

    /**
     * 添加商品
     * @param goodsParam
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert( GoodsInsertParam goodsParam){
        return goodsService.insert(goodsParam);
    }

    /**
     * 后台获取商品列表
     * @param goodsListParam
     * @return
     */
    @RequestMapping(value = "/getAllList",method = RequestMethod.POST)
    public PageInfos getAllList(GoodsListParam goodsListParam){
        return goodsService.getAllList(goodsListParam);
    }

    /**
     * 改变商品是否特卖
     * @param param
     * @return
     */
    @RequestMapping(value = "/changeRecGoodsState",method = RequestMethod.POST)
    public int changeRecGoodsState(ChangeRecGoodsStateParam param){
        return goodsService.changeRecGoodsState(param);
    }

    /**
     * 获取建材详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/getGoodsDetailById",method = RequestMethod.GET)
    public GoodsPojo getGoodsDetailById(int id){
        return goodsService.getGoodsById(id);
    }

}
