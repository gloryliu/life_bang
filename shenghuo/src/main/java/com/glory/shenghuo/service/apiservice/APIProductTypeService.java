package com.glory.shenghuo.service.apiservice;

import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-08 10:19
 **/
@Service
public class APIProductTypeService {

    @Autowired
    ProductTypeMapper productTypeMapper;

    /**
     * 根据父id和类型查询分类
     * @param parentId
     * @param type
     * @return
     */
    public ResponseEntity<Object> getProductClassify(int parentId,int type){
        HashMap<String,Integer> param = new HashMap<>();
        param.put("parentId",parentId);
        param.put("type",type);
        return MyResponseUtil.ok(productTypeMapper.getListByParentIdAndType(param));
    }
}
