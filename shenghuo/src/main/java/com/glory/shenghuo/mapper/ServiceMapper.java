package com.glory.shenghuo.mapper;

import com.github.pagehelper.Page;
import com.glory.shenghuo.api.goods.param.AppGetDataListParam;
import com.glory.shenghuo.api.service.param.ServiceListParam;
import com.glory.shenghuo.api.service.pojo.ServicePojo;

import java.util.List;

public interface ServiceMapper extends BaseMapper {

    //添加服务
    int add(ServicePojo pojo);

    //删除服务
    int delete(int id);

    //修改服务
    int update(ServicePojo pojo);

    //服务详情
    ServicePojo getDetail(int id);

    //后台获取服务列表
    Page<ServicePojo> getAllList(ServiceListParam serviceListParam);

    //获取广告位的服务
    List<ServicePojo> getBannerServiceList();

    //获取推荐的服务列表
    List<ServicePojo> getRecServiceList();

    //获取优惠的服务列表
    List<ServicePojo> getDiscountServiceList();

    //app获取服务列表
    Page<ServicePojo> appGetServiceList(AppGetDataListParam param);


}
