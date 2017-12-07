package com.glory.shenghuo.service.apiservice;

import com.alibaba.fastjson.JSON;
import com.glory.shenghuo.api.serviceprovider.param.ServiceProviderParam;
import com.glory.shenghuo.api.serviceprovider.pojo.ServiceProviderPoJo;
import com.glory.shenghuo.common.BusinessException;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.ServiceProviderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-07 20:23
 **/
@Service
public class APIServiceProviderService {

    @Autowired
    ServiceProviderMapper serviceProviderMapper;

    /**
     * 添加服务商申请信息
     * @param param
     * @return
     */
    public ResponseEntity<Object> add(ServiceProviderParam param) throws BusinessException {

        ResponseEntity responseEntity = null;
        if(param.getTypeIds()==null){
            throw new BusinessException("服务内容为空");
        }
        ServiceProviderPoJo providerPoJo = serviceProviderMapper.getProviderInfoByUserId(param.getUserId());
        if(providerPoJo==null){
            providerPoJo = new ServiceProviderPoJo();
            BeanUtils.copyProperties(param,providerPoJo);
            providerPoJo.setStatus(0);
            providerPoJo.setServiceRange(JSON.toJSONString(param.getTypeIds()));
            if(serviceProviderMapper.add(providerPoJo)>0){
                responseEntity =  MyResponseUtil.ok("添加成功");
            }else{
                throw new BusinessException("添加失败");
            }
        }else {
            providerPoJo.setController(param.getController());
            providerPoJo.setContacts(param.getContacts());
            providerPoJo.setCompanyAddress(param.getCompanyAddress());
            providerPoJo.setServiceRange(JSON.toJSONString(param.getTypeIds()));
            if(serviceProviderMapper.update(providerPoJo)>0){
                responseEntity =  MyResponseUtil.ok("添加成功");
            }else {
                throw new BusinessException("添加失败");
            }
        }

        return responseEntity;
    }

    /**
     * 获取服务商信息
     * @param userId
     * @return
     */
    public ResponseEntity<Object> getProviderInfo(int userId){
        return MyResponseUtil.ok(serviceProviderMapper.getProviderInfoByUserId(userId));
    }
}
