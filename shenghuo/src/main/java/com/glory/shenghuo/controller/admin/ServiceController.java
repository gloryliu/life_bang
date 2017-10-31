package com.glory.shenghuo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/controller/service")
public class ServiceController {

    @RequestMapping("/serviceList")
    public String  serviceList(){
        return "admin/service/service_list";
    }

    @RequestMapping("/serviceEdit")
    public String serviceEdit(ModelMap map, Integer goodsId, Integer type){
        if (goodsId != null && goodsId != 0){
            map.put("goodsId",goodsId);
        }
        if (type != null && type != 0){
            map.put("type",type);//type=1，编辑；其他值，新增
        }
        return "admin/goods/goods_edit";
    }
}
