package com.glory.shenghuo.mapper;

import com.glory.shenghuo.api.serviceprovider.pojo.ServiceProviderPoJo;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-07 13:35
 **/
public interface ServiceProviderMapper extends BaseMapper {

    /**
     * 添加服务商信息
     * @param poJo
     * @return
     */
    int add(ServiceProviderPoJo poJo);

    /**
     * 更新服务商信息
     * @param poJo
     * @return
     */
    int update(ServiceProviderPoJo poJo);


    /**
     * 根据用户信息获取服务商信息
     * @param userId
     * @return
     */
    ServiceProviderPoJo getProviderInfoByUserId(int userId);


}
