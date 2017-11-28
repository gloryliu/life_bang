package com.glory.shenghuo.mapper;

import com.github.pagehelper.Page;
import com.glory.shenghuo.api.user.param.UserParam;
import com.glory.shenghuo.api.user.pojo.UserPoJo;

public interface UserMapper extends BaseMapper{

    /**
     * 添加新用户
     * @param userPoJo
     * @return
     */
    int add(UserPoJo userPoJo);

    /**
     * 根据电话号码查询用户
     * @param phone
     * @return
     */
    UserPoJo findUserByPhone(String phone);

    /**
     * 根据uierid查询用户
     * @param userId
     * @return
     */
    UserPoJo findUserByUserId(int userId);

    /**
     * 用户修改
     * @param userPoJo
     * @return
     */
    int updateUser(UserPoJo userPoJo);

    /**
     * web获取用户列表
     * @param userParam
     * @return
     */
    Page<UserPoJo> getAllList(UserParam userParam);

    /**
     * 获取用户详细信息
     */
    UserPoJo getUserInfoById(int id);
}
