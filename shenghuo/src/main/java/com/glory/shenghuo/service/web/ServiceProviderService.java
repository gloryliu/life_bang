package com.glory.shenghuo.service.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glory.shenghuo.api.serviceprovider.param.ServiceProviderListParam;
import com.glory.shenghuo.api.serviceprovider.pojo.ServiceProviderPoJo;
import com.glory.shenghuo.mapper.ServiceProviderMapper;
import com.glory.shenghuo.util.PageInfos;
import com.glory.shenghuo.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderMapper serviceProviderMapper;

    /**
     * 获取所有服务商信息列表
     * @param serviceProviderListParam
     * @return
     */
    public PageInfos getServicePrivoderList(ServiceProviderListParam serviceProviderListParam){
        PageHelper.startPage(serviceProviderListParam.getPageNum(), serviceProviderListParam.getPageSize(), true);
        Page<ServiceProviderPoJo> serviceProviderPoJos = serviceProviderMapper.getServiceProviderList(serviceProviderListParam);
        PageInfo<ServiceProviderPoJo> data = new PageInfo<>(serviceProviderPoJos);
        return UtilTools.pageChange(data,serviceProviderPoJos);
    }

    public int checkServiceProvider(Integer checkid){
        return serviceProviderMapper.check(checkid);
    }
}
