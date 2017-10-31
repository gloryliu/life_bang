package com.glory.shenghuo.mapper;

import com.github.pagehelper.Page;
import com.glory.shenghuo.api.service.param.ServiceListParam;
import com.glory.shenghuo.api.service.pojo.ServicePojo;

public interface ServiceMapper extends BaseMapper {

    int add(ServicePojo pojo);

    int delete(int id);

    int update(ServicePojo pojo);

    ServicePojo getDetail(int id);

    Page<ServicePojo> getAllList(ServiceListParam serviceListParam);

}
