package com.glory.shenghuo.api.goods.json;

import com.glory.shenghuo.api.goods.pojo.GoodsImagePojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-11-05 15:53
 * 商品详情
 **/
public class GoodsDetailJson implements Serializable{

    //商品id
    private int id;

    //商品图片
    private List<GoodsImagePojo> goodsImages;

    //商品名称
    private String goodsName;

    //商品价格
    private int goodsPrice;

    //商品图片
    private String goodsImg;

    //商品详情
    private String goodsDetailUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<GoodsImagePojo> getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(List<GoodsImagePojo> goodsImages) {
        this.goodsImages = goodsImages;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDetailUrl() {
        return goodsDetailUrl;
    }

    public void setGoodsDetailUrl(String goodsDetailUrl) {
        this.goodsDetailUrl = goodsDetailUrl;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
}
