package com.glory.shenghuo.mapper;

import com.glory.shenghuo.api.user.param.UpdatePhoneParam;
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
}
