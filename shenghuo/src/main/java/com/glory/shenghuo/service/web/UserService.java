package com.glory.shenghuo.service.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.glory.shenghuo.api.user.param.*;
import com.glory.shenghuo.api.user.pojo.UserPoJo;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.UserMapper;
import com.glory.shenghuo.util.PageInfos;
import com.glory.shenghuo.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * web获取用户列表
     * @param userParam
     * @return
     */
    public PageInfos getUserList(UserParam userParam){
        PageHelper.startPage(userParam.getPageNum(), userParam.getPageSize(), true);
        Page<UserPoJo> userPojos = userMapper.getAllList(userParam);
        PageInfo<UserPoJo> data = new PageInfo<>(userPojos);
        return UtilTools.pageChange(data,userPojos);
    }

    /**
     * 根据用户id号查询出用户信息
     */
    public UserPoJo getUserInfoById(Integer id){
        return userMapper.getUserInfoById(id);
    }
}
