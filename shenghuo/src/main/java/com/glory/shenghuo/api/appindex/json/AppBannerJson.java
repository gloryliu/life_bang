package com.glory.shenghuo.api.appindex.json;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-02 14:17
 **/
public class AppBannerJson implements Serializable {

    @ApiModelProperty("产品id")
    private int id;

    @ApiModelProperty("图片")
    private String img;

    @ApiModelProperty("广告类型：1为建材类，2为服务类")
    private int type;

    public AppBannerJson(){

    }

    public AppBannerJson(int id, String img, int type) {
        this.id = id;
        this.img = img;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
