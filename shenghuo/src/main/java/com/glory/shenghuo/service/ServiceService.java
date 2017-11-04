package com.glory.shenghuo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glory.shenghuo.api.service.param.ServiceListParam;
import com.glory.shenghuo.api.service.pojo.ServicePojo;
import com.glory.shenghuo.mapper.ServiceMapper;
import com.glory.shenghuo.util.PageInfos;
import com.glory.shenghuo.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    @Autowired
    private ServiceMapper serviceMapper;


    /**
     * web添加服务
     * @param pojo
     * @return
     */
    public int addService(ServicePojo pojo){
        return serviceMapper.add(pojo);
    }

    /**
     * web服务列表
     * @param serviceListParam
     * @return
     */
    public PageInfos getServiceList(ServiceListParam serviceListParam){
        PageHelper.startPage(serviceListParam.getPageNum(),serviceListParam.getPageSize(),true);
        Page<ServicePojo> page = serviceMapper.getAllList(serviceListParam);
        PageInfo<ServicePojo> data = new PageInfo<>(page);
        return UtilTools.pageChange(data,page);
    }

    /**
     * 获取服务的详情
     * @param id
     * @return
     */
    public ServicePojo getServiceDetail(int id){
        return serviceMapper.getDetail(id);
    }
}
