package com.glory.shenghuo.mapper;


import com.github.pagehelper.Page;
import com.glory.shenghuo.api.goods.param.GoodsInsertParam;
import com.glory.shenghuo.api.goods.param.GoodsListParam;
import com.glory.shenghuo.api.goods.pojo.GoodsPojo;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-18 11:22
 **/
public interface GoodsMapper extends BaseMapper {
    int insert(GoodsInsertParam goodsParam);

    int update(GoodsPojo goodsPojo);

    GoodsPojo getDetail(int id);

    Page<GoodsPojo> getAllList(GoodsListParam goodsListParam);

}