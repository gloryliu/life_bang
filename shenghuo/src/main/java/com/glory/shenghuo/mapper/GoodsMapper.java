package com.glory.shenghuo.mapper;


import com.github.pagehelper.Page;
import com.glory.shenghuo.api.goods.param.AppGetDataListParam;
import com.glory.shenghuo.api.goods.param.ChangeRecGoodsStateParam;
import com.glory.shenghuo.api.goods.param.GoodsInsertParam;
import com.glory.shenghuo.api.goods.param.GoodsListParam;
import com.glory.shenghuo.api.goods.pojo.GoodsPojo;

import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-18 11:22
 **/
public interface GoodsMapper extends BaseMapper {

    //添加商品
    int insert(GoodsInsertParam goodsParam);

    //修改商品
    int update(GoodsPojo goodsPojo);

    //商品详情
    GoodsPojo getDetail(int id);

    //后台商品列表
    Page<GoodsPojo> getAllList(GoodsListParam goodsListParam);

    //获取广告位的商品
    List<GoodsPojo> getBannerGoodsList();

    //获取推荐的商品
    List<GoodsPojo> getRecGoodsList();

    //改变是否特卖商品
    int changeRecGoodsState(ChangeRecGoodsStateParam param);

    //app获取建材列表
    Page<GoodsPojo> appGetGoodsList(AppGetDataListParam param);
}