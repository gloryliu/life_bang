package com.glory.shenghuo.service;

import com.glory.shenghuo.api.producttype.pojo.ProductTypePoJo;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    public ResponseEntity<Object> add(ProductTypePoJo param){

        if(productTypeMapper.add(param)>0){
            return MyResponseUtil.ok("添加成功");
        }else {
            return MyResponseUtil.error("添加失败");
        }
    }

    public ResponseEntity<Object> update(ProductTypePoJo param){

        if(productTypeMapper.update(param)>0){
            return MyResponseUtil.ok("更新成功");
        }else{
            return MyResponseUtil.error("更新失败");
        }
    }

    public ResponseEntity<Object> delete(int id){

        if(productTypeMapper.delete(id)>0){
            return MyResponseUtil.ok("删除成功");
        }else{
            return MyResponseUtil.error("删除失败");
        }
    }

    public ResponseEntity<Object> getTypeList(int id){

        ArrayList<ProductTypePoJo> menuList = productTypeMapper.getListByParentId(id);
        for (ProductTypePoJo menu: menuList) {
            ArrayList<ProductTypePoJo> child
        }
    }

}
