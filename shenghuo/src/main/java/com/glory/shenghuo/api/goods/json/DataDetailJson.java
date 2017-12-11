package com.glory.shenghuo.api.goods.json;

import com.glory.shenghuo.api.image.pojo.ImagePojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-11-05 15:53
 * 商品详情
 **/
public class DataDetailJson implements Serializable{

    //商品id
    private int id;

    //轮播图片
    private List<ImagePojo> images;

    //名称
    private String name;

    //价格
    private int price;

    //图片
    private String img;

    //详情
    private String detailUrl;

    // 数据类型1为建材详情、2为服务详情
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ImagePojo> getImages() {
        return images;
    }

    public void setImages(List<ImagePojo> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
