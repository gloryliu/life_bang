package com.glory.shenghuo.service.apiservice;

import com.glory.shenghuo.api.goods.json.GoodsDetailJson;
import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.GoodsImageMapper;
import com.glory.shenghuo.mapper.GoodsMapper;
import com.glory.shenghuo.util.ConstantUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-11-05 15:51
 **/

@Service
public class APIGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsImageMapper goodsImageMapper;


    /**
     * 获取商品详情
     * @param id
     * @return
     */
    public ResponseEntity<Object>  appGetGoodsDetailById(int id){
        GoodsDetailJson  goodsDetailJson = null;
        GoodsPojo goodsPojo = goodsMapper.getDetail(id);
        if(goodsPojo!=null){
            goodsDetailJson = new GoodsDetailJson();
            BeanUtils.copyProperties(goodsPojo,goodsDetailJson);
            goodsDetailJson.setGoodsImages(goodsImageMapper.getAllImagesByGoodsId(id));
            goodsDetailJson.setGoodsDetailUrl(ConstantUtils.getBaseHost()+"/controller/goods/getGoodsDetailHtml?id="+goodsPojo.getId());
        }
        return MyResponseUtil.ok(goodsDetailJson);
    }
}
