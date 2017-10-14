package com.glory.shenghuo.mapper;


import com.glory.shenghuo.api.deliveryaddress.pojo.DeliveryAddressPojo;

import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-18 11:22
 **/
public interface DeliveryAddressMapper extends BaseMapper {

    int insert(DeliveryAddressPojo deliveryAddressPojo);

    int update(DeliveryAddressPojo deliveryAddressPojo);

    DeliveryAddressPojo getDeliveryAddressById(int id);

    int deleteById(int id);

    List<DeliveryAddressPojo> getAllList();

    List<DeliveryAddressPojo> getAllListByUserid(int userId);

}