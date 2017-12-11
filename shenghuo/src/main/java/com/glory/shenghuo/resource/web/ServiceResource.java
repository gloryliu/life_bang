package com.glory.shenghuo.resource.web;

import com.glory.shenghuo.api.service.param.ServiceInsertParam;
import com.glory.shenghuo.api.service.param.ServiceListParam;
import com.glory.shenghuo.api.service.pojo.ServicePojo;
import com.glory.shenghuo.service.web.ServiceService;
import com.glory.shenghuo.util.PageInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/resource/service")
public class ServiceResource {


    @Autowired
    private ServiceService serviceService;

    @RequestMapping("/addService")
    public int addService(ServiceInsertParam param){
        return serviceService.addService(param);
    }
    @RequestMapping("/updateService")
    public int updateService(ServicePojo pojo){
        return serviceService.updateService(pojo);
    }
    @RequestMapping("/detailService")
    public ServicePojo detailService(Integer serviceId){
        return serviceService.getServiceDetail(serviceId);
    }
    /**
     * web服务列表
     * @param serviceListParam
     * @return
     */
    @RequestMapping(value = "/getServiceList",method = RequestMethod.POST)
    public PageInfos getServiceList(ServiceListParam serviceListParam){
        return serviceService.getServiceList(serviceListParam);
    }

    /**
     * //根据服务id修改其删除状态
     * @param serviceId
     */
    @RequestMapping("/changeServiceDeleteFlag")
    public int changeServiceDeleteFlag(int serviceId){
        return serviceService.changeServiceDeleteFlag(serviceId);
    }
}
