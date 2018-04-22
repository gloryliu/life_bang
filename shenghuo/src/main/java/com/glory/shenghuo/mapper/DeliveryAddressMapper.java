package com.glory.shenghuo.mapper;


import com.glory.shenghuo.api.deliveryaddress.pojo.DeliveryAddressPojo;

import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-18 11:22
 **/
public interface DeliveryAddressMapper extends BaseMapper {

    /**
     *
     * @param deliveryAddressPojo
     * @return
     */
    int insert(DeliveryAddressPojo deliveryAddressPojo);

    /**
     *
     * @param deliveryAddressPojo
     * @return
     */
    int update(DeliveryAddressPojo deliveryAddressPojo);

    /**
     *
     * @param id
     * @return
     */
    DeliveryAddressPojo getDeliveryAddressById(int id);

    /**
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     *
     * @return
     */
    List<DeliveryAddressPojo> getAllList();

    /**
     *
     * @param userId
     * @return
     */
    List<DeliveryAddressPojo> getAllListByUserid(int userId);

}