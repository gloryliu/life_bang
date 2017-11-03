package com.glory.shenghuo.service;

import com.glory.shenghuo.api.appindex.json.AppBannerJson;
import com.glory.shenghuo.api.appindex.json.AppIndexJson;
import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.api.service.pojo.ServicePojo;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.GoodsMapper;
import com.glory.shenghuo.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-02 14:07
 **/
@Service
public class AppIndexService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ServiceMapper serviceMapper;

    /**
     * 构建APP首页的数据
     * @return
     */
    public ResponseEntity<Object> getAppIndexData(){

        AppIndexJson appIndexJson = new AppIndexJson();
        List<AppBannerJson> bannerJsons = new ArrayList<>();

        List<ServicePojo> servicePojoList = serviceMapper.getBannerServiceList();
        for (ServicePojo service: servicePojoList) {
            bannerJsons.add(new AppBannerJson(service.getId(),service.getServiceImg(),2));
        }

        List<ServicePojo> recServices = serviceMapper.getRecServiceList();
        appIndexJson.setBanners(bannerJsons);
        appIndexJson.setRecService(recServices);
        return MyResponseUtil.ok(appIndexJson);
    }

    /**
     * 构建APP建材页面数据
     * @return
     */
    public ResponseEntity<Object> getAppJiancaiData(){
        AppIndexJson appJiancaiJson = new AppIndexJson();
        List<AppBannerJson> bannerJsons = new ArrayList<>();
        List<GoodsPojo> goodsPojoList = goodsMapper.getBannerGoodsList();
        for (GoodsPojo goods: goodsPojoList) {
            bannerJsons.add(new AppBannerJson(goods.getId(),goods.getGoodsImg(),1));
        }

        List<GoodsPojo> recGoods = goodsMapper.getRecGoodsList();
        appJiancaiJson.setBanners(bannerJsons);
        appJiancaiJson.setRecGoods(recGoods);
        return MyResponseUtil.ok(appJiancaiJson);
    }
}
