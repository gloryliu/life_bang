package com.glory.shenghuo.api.appindex.json;

import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.api.service.pojo.ServicePojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-02 14:16
 **/
public class AppIndexJson implements Serializable{

    //广告位的数据
    private List<AppBannerJson> banners;

    //推荐的服务
    private List<ServicePojo> recService;

    //特卖
    private List<GoodsPojo> recGoods;

    public List<AppBannerJson> getBanners() {
        return banners;
    }

    public void setBanners(List<AppBannerJson> banners) {
        this.banners = banners;
    }

    public List<ServicePojo> getRecService() {
        return recService;
    }

    public void setRecService(List<ServicePojo> recService) {
        this.recService = recService;
    }

    public List<GoodsPojo> getRecGoods() {
        return recGoods;
    }

    public void setRecGoods(List<GoodsPojo> recGoods) {
        this.recGoods = recGoods;
    }
}
