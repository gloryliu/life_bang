package com.glory.shenghuo.service.apiservice;

import com.glory.shenghuo.api.collection.param.AddCollectionParam;
import com.glory.shenghuo.api.collection.pojo.CollectionPojo;
import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.api.service.pojo.ServicePojo;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.CollectionMapper;
import com.glory.shenghuo.mapper.GoodsMapper;
import com.glory.shenghuo.mapper.ServiceMapper;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-09 10:47
 **/
@Service
public class APICollectionService {


    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ServiceMapper serviceMapper;


    /**
     *添加收藏
     * @param param
     * @return
     */
    public ResponseEntity<Object> addCollection(AddCollectionParam param){

        ResponseEntity<Object> responseEntity = null;

        CollectionPojo collectionPojo = new CollectionPojo();
        collectionPojo.setUserId(param.getUserId());
        collectionPojo.setProductType(param.getProductType());

        switch (param.getProductType()){
            case 1:
                GoodsPojo goodsPojo = goodsMapper.getDetail(param.getProductId());
                if(goodsPojo!=null){

                    collectionPojo.setProductName(goodsPojo.getGoodsName());
                    collectionPojo.setProductPrice(goodsPojo.getGoodsPrice());
                    collectionPojo.setProductImg(goodsPojo.getGoodsImg());
                    if(collectionMapper.add(collectionPojo)>0){
                        responseEntity = MyResponseUtil.ok("收藏成功");
                    }else{
                        responseEntity = MyResponseUtil.error("添加收藏失败");
                    }
                }else{
                    responseEntity = MyResponseUtil.error("建材不存在");
                }
                break;
            case 2:
                ServicePojo servicePojo = serviceMapper.getDetail(param.getProductId());
                if(servicePojo!=null){

                    collectionPojo.setProductName(servicePojo.getServiceName());
                    collectionPojo.setProductPrice(servicePojo.getServicePrice());
                    collectionPojo.setProductImg(servicePojo.getServiceImg());
                    if(collectionMapper.add(collectionPojo)>0){
                        responseEntity = MyResponseUtil.ok("收藏成功");
                    }else{
                        responseEntity = MyResponseUtil.error("添加收藏失败");
                    }
                }else{
                    responseEntity = MyResponseUtil.error("服务不存在");
                }
                break;
            default:
                    responseEntity = MyResponseUtil.error("产品类型不合法");
        }

        return responseEntity;
    }

    /**
     * 删除收藏
     * @param id
     * @return
     */
    public ResponseEntity<Object> deleteCollection(int id){

        if(collectionMapper.delete(id)>0){
            return MyResponseUtil.ok("删除成功");
        }else {
            return MyResponseUtil.error("删除失败");
        }
    }


    /**
     * 根据用户id获取所有收藏
     * @param userId
     * @return
     */
    public ResponseEntity<Object> getAllCollectionByUserId(int userId){
        return MyResponseUtil.ok(collectionMapper.getAllListByUserId(userId));
    }
}
