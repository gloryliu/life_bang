package com.glory.shenghuo.controller.admin;

import com.glory.shenghuo.service.web.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/controller/serviceprovider")
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @RequestMapping("/serviceProviderList")
    public String serviceProviderList(){
        return "admin/serviceprovider/serviceprovider_list";
    }
}
