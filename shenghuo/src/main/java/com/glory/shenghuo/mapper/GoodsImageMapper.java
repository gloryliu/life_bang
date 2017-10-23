package com.glory.shenghuo.mapper;

import com.glory.shenghuo.api.goods.pojo.GoodsImagePojo;

import java.util.List;

public interface GoodsImageMapper extends BaseMapper {

    int insert(GoodsImagePojo imagePojo);

    int delete(int id);

    List<GoodsImagePojo> getAllImagesByGoodsId(int goodsId);

}
