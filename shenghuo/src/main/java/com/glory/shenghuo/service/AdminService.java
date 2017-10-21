package com.glory.shenghuo.service;

import com.glory.shenghuo.api.admin.pojo.AdminPojo;
import com.glory.shenghuo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-18 12:04
 **/
@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public int insert(AdminPojo adminPojo){
        adminPojo.setRole(1);
        return adminMapper.insert(adminPojo);
    }

    public int update(AdminPojo adminPojo){
        return adminMapper.update(adminPojo);
    }

    public int deleteById(int id){
        return adminMapper.deleteById(id);
    }

    public List<AdminPojo> getAllList(){
        return adminMapper.getAllList();
    }

    public AdminPojo getAdminByMap(Map<String, String> map){
        return adminMapper.getAdminByMap(map);
    }
}
