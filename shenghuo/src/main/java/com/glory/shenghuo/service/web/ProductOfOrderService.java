package com.glory.shenghuo.service.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.api.order.param.ProductOfOrderParam;
import com.glory.shenghuo.api.order.pojo.ProductOfOrderPojo;
import com.glory.shenghuo.mapper.ProductOfOrderMapper;
import com.glory.shenghuo.util.PageInfos;
import com.glory.shenghuo.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOfOrderService {

    @Autowired
    private ProductOfOrderMapper productOfOrderMapper;

    /**
     * 根据订单id号查询出所有的订单信息
     * @param productOfOrderParam
     * @return
     */
    public PageInfos getAllProductByOrderId(ProductOfOrderParam productOfOrderParam){

        PageHelper.startPage(productOfOrderParam.getPageNum(),productOfOrderParam.getPageSize(),true);
        Page<ProductOfOrderPojo> productOfOrderPojos = productOfOrderMapper.getAllProductByOrderId(productOfOrderParam.getOrderId());
        PageInfo<ProductOfOrderPojo> data = new PageInfo<>(productOfOrderPojos);
        return UtilTools.pageChange(data,productOfOrderPojos);
    }
}
