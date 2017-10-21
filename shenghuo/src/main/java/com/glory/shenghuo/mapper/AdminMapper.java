package com.glory.shenghuo.mapper;


import com.glory.shenghuo.api.admin.pojo.AdminPojo;

import java.util.List;
import java.util.Map;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-18 11:22
 **/
public interface AdminMapper extends BaseMapper {
    int insert(AdminPojo adminPojo);

    int update(AdminPojo adminPojo);

    int deleteById(int id);

    List<AdminPojo> getAllList();

    AdminPojo getAdminByMap(Map<String, String> map);
}