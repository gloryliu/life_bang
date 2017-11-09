package com.glory.shenghuo.mapper;

import com.glory.shenghuo.api.collection.pojo.CollectionPojo;

import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-09 10:30
 **/
public interface CollectionMapper extends BaseMapper {

    int add(CollectionPojo pojo);

    int delete(int id);

    List<CollectionPojo> getAllListByUserId(int userId);
}
