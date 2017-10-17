package com.glory.shenghuo.mapper;

import com.glory.shenghuo.api.producttype.pojo.ProductTypePoJo;

import java.util.ArrayList;

public interface ProductTypeMapper {


    int add(ProductTypePoJo typePoJo);

    int update(ProductTypePoJo typePoJo);

    int delete(int id);

    ArrayList<ProductTypePoJo> getListByParentId(int id);

}
