package com.glory.shenghuo.service;


import com.glory.shenghuo.api.deliveryaddress.param.DeliveryAddressParam;
import com.glory.shenghuo.api.deliveryaddress.pojo.DeliveryAddressPojo;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.DeliveryAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-18 12:04
 **/
@Service
public class DeliveryAddressService {


    @Autowired
    private DeliveryAddressMapper deliveryAddressPojoMapper;

    /**
     * 添加收货地址
     * @param param
     * @return
     */
     public ResponseEntity<Object> insert(DeliveryAddressParam param){

         ResponseEntity<Object> responseEntity = null;

        DeliveryAddressPojo deliveryAddressPojo = new DeliveryAddressPojo();
        deliveryAddressPojo.setName(param.getName());
        deliveryAddressPojo.setDetail(param.getDetail());
        deliveryAddressPojo.setPhone(param.getPhone());
        deliveryAddressPojo.setUserId(param.getUserId());
        if(deliveryAddressPojoMapper.insert(deliveryAddressPojo)>0){
            responseEntity = MyResponseUtil.ok("添加成功");
        }else{
            responseEntity = MyResponseUtil.error(MyResponseUtil.FAIL,"添加失败");
        }

        return responseEntity;
    }

    /**A
     * 跟进userid返回地址列表
     * @param userid
     * @return
     */
    public ResponseEntity<Object> appGetAllListByUserid(int userid){

        return MyResponseUtil.ok(deliveryAddressPojoMapper.getAllListByUserid(userid));

    }

    /**
     * 修改收货地址
     * @param deliveryAddressPojo
     * @return
     */
    public ResponseEntity<Object> update(DeliveryAddressPojo deliveryAddressPojo){

        ResponseEntity<Object> responseEntity = null;
        if(deliveryAddressPojoMapper.update(deliveryAddressPojo)>0){
            responseEntity = MyResponseUtil.ok("修改成功");
        }else{
            responseEntity = MyResponseUtil.error(MyResponseUtil.FAIL,"修改失败");
        }
        return responseEntity;
    }

    /**
     * 跟进id删除
     * @param id
     * @return
     */
    public ResponseEntity<Object> deleteById(int id){

        ResponseEntity<Object> responseEntity = null;
        if(deliveryAddressPojoMapper.deleteById(id)>0){
            responseEntity = MyResponseUtil.ok("删除成功");
        }else{
            responseEntity = MyResponseUtil.error(MyResponseUtil.FAIL,"删除失败");
        }
        return responseEntity;
    }

    DeliveryAddressPojo getDeliveryAddressById(int id){
        return deliveryAddressPojoMapper.getDeliveryAddressById(id);
    }



    List<DeliveryAddressPojo> getAllList(){
        return deliveryAddressPojoMapper.getAllList();
    }


}
