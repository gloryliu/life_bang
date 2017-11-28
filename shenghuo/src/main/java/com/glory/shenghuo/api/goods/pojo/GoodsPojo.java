package com.glory.shenghuo.api.goods.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-18 11:22
 **/
public class GoodsPojo implements Serializable{

    //商品id
    private int id ;

    //商品名称
    private String goodsName;

    //商品价格
    private int goodsPrice;

    //原始价格
    private int originalPrice;

    //利润
    private int profit;

    //商品类型
    private int goodsType;

    //商品详情
    private String goodsDetail;

    //库存
    private int stock;

    //是否在广告位展示商品
    private int isBanner;

    //商品图片
    private String goodsImg;

    //是否特卖商品
    private int isRec;

    //服务商信息
    private String serviceProvider;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIsBanner() {
        return isBanner;
    }

    public void setIsBanner(int isBanner) {
        this.isBanner = isBanner;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public int getIsRec() {
        return isRec;
    }

    public void setIsRec(int isRec) {
        this.isRec = isRec;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}