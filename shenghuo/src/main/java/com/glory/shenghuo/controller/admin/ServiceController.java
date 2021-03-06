package com.glory.shenghuo.controller.admin;

import com.glory.shenghuo.api.service.pojo.ServicePojo;
import com.glory.shenghuo.service.web.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/controller/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @RequestMapping("/serviceList")
    public String  serviceList(){
        return "admin/service/service_list";
    }

    @RequestMapping("/serviceAdd")
    public String serviceAdd(){
        return "admin/service/service_add";
    }

    @RequestMapping("/serviceEdit")
    public String serviceEdit(ModelMap map, Integer type, Integer serviceId){
        if (serviceId != null && serviceId != 0){
            map.put("serviceId",serviceId);
        }
        if (type != null && type != 0){
            map.put("type",type);//type=1，编辑；其他值，新增
        }
        return "admin/service/service_edit";
    }

    /**
     * 获取商品详情Html
     * @param id
     * @return
     */
    @RequestMapping(value = "/getServiceDetailHtml",method = RequestMethod.GET)
    public String getServiceDetailHtml(ModelMap model,int id){
        ServicePojo servicePojo = serviceService.getServiceDetail(id);
        if(servicePojo!=null){
            model.put("serviceDetail",servicePojo.getServiceDetail());
        }else{
            model.put("serviceDetail","没有数据");
        }
        return "admin/service/servicedetail_html";
    }
}
