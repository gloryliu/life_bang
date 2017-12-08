package com.glory.shenghuo.resource.web;

import com.glory.shenghuo.api.serviceprovider.param.ServiceProviderListParam;
import com.glory.shenghuo.service.web.ServiceProviderService;
import com.glory.shenghuo.util.PageInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/resource/serviceprovider")
public class ServiceProviderResource {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @RequestMapping("/serviceProviderList")
    public PageInfos getServiceProviderList(ServiceProviderListParam serviceProviderListParam){
        return serviceProviderService.getServicePrivoderList(serviceProviderListParam);
    }
    @RequestMapping("/serviceProviderCheck")
    public int checkServiceProviderStatus(Integer checkid){
        return serviceProviderService.checkServiceProvider(checkid);
    }
}
