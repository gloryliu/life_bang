package com.glory.shenghuo.service.apiservice;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glory.shenghuo.api.goods.json.DataDetailJson;
import com.glory.shenghuo.api.goods.param.AppGetDataListParam;
import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.api.service.pojo.ServicePojo;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.GoodsImageMapper;
import com.glory.shenghuo.mapper.GoodsMapper;
import com.glory.shenghuo.mapper.ServiceMapper;
import com.glory.shenghuo.util.ConstantUtils;
import com.glory.shenghuo.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-11-05 15:51
 **/

@Service
public class APIDataService {

    /**
     * 建材
     */
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 服务
     */
    @Autowired
    private ServiceMapper serviceMapper;

    /**
     * 图片
     */
    @Autowired
    private GoodsImageMapper goodsImageMapper;


    /**
     * 获取建材详情
     * @param id
     * @return
     */
    public ResponseEntity<Object>  appGetGoodsDetailById(int id){
        DataDetailJson dataDetailJson = null;
        GoodsPojo goodsPojo = goodsMapper.getDetail(id);
        if(goodsPojo!=null){
            dataDetailJson = new DataDetailJson();
            dataDetailJson.setId(goodsPojo.getId());
            dataDetailJson.setImages(goodsImageMapper.getAllImagesByGoodsId(id));
            dataDetailJson.setName(goodsPojo.getGoodsName());
            dataDetailJson.setPrice(goodsPojo.getGoodsPrice());
            dataDetailJson.setImg(goodsPojo.getGoodsImg());
            dataDetailJson.setDetailUrl(ConstantUtils.getBaseHost()+"/controller/goods/getGoodsDetailHtml?id="+goodsPojo.getId());
            dataDetailJson.setType(1);
        }
        return MyResponseUtil.ok(dataDetailJson);
    }

    /**
     * 获取服务详情
     * @param id
     * @return
     */
    public ResponseEntity<Object> appGetServiceDetailById(int id){
        DataDetailJson dataDetailJson = null;
        ServicePojo servicePojo = serviceMapper.getDetail(id);
        if(servicePojo!=null){
            dataDetailJson = new DataDetailJson();
            dataDetailJson.setId(servicePojo.getId());
            dataDetailJson.setImages(goodsImageMapper.getAllImagesByGoodsId(id));
            dataDetailJson.setName(servicePojo.getServiceName());
            dataDetailJson.setPrice(servicePojo.getServicePrice());
            dataDetailJson.setImg(servicePojo.getServiceImg());
            dataDetailJson.setDetailUrl(ConstantUtils.getBaseHost()+"/controller/service/getServiceDetailHtml?id="+servicePojo.getId());
            dataDetailJson.setType(2);
        }
        return MyResponseUtil.ok(dataDetailJson);
    }

    /**
     * app获取建材列表
     * @param param
     * @return
     */
    public ResponseEntity<Object> appGetGoodsList(AppGetDataListParam param){
        PageHelper.startPage(param.getPageNum(),param.getPageSize(),true);
        Page<GoodsPojo> goodsList = goodsMapper.appGetGoodsList(param);
        PageInfo<GoodsPojo> pageInfo = new PageInfo<>(goodsList);
        return MyResponseUtil.ok(UtilTools.pageChange(pageInfo,goodsList));
    }

    /**
     * app获取服务列表
     * @param param
     * @return
     */
    public ResponseEntity<Object> appGetServiceList(AppGetDataListParam param){
        PageHelper.startPage(param.getPageNum(),param.getPageSize(),true);
        Page<ServicePojo> serviceList = serviceMapper.appGetServiceList(param);
        PageInfo<ServicePojo> pageInfo = new PageInfo<>(serviceList);
        return MyResponseUtil.ok(UtilTools.pageChange(pageInfo,serviceList));
    }

}
