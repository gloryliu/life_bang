package com.glory.shenghuo.mapper;

import com.glory.shenghuo.api.producttype.pojo.ProductTypePoJo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ProductTypeMapper extends BaseMapper{


    int add(ProductTypePoJo typePoJo);

    int update(ProductTypePoJo typePoJo);

    int delete(int id);

    /**
     * 添加商品时的分类
     * @param type
     * @return
     */
    ArrayList<ProductTypePoJo> getAllList(int type);

    /**
     * 给app提供分类根据parentId和type查询子节点
     * @param param
     * @return
     */
    ArrayList<ProductTypePoJo> getListByParentIdAndType(HashMap<String,Integer> param);

    /**
     * 根据一组id批量查询分类
     * @param Ids
     * @return
     */
    List<ProductTypePoJo> getListByIds(@Param("Ids") List<Integer> Ids);

}
