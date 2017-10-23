package com.glory.shenghuo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-21 21:06
 **/
@ApiIgnore
@Controller
@RequestMapping("/controller/goods")
public class GoodsController {

    @RequestMapping("/goodstype")
    public String goodstype(){
        return "admin/goods/product_type_list";
    }

    @RequestMapping("/edit")
    public String edit(ModelMap map, Integer goodsId, Integer type){
        if (goodsId != null && goodsId != 0){
            map.put("goodsId",goodsId);
        }
        if (type != null && type != 0){
            map.put("type",type);//type=1，编辑；其他值，新增
        }
        return "goods/goods_edit";
    }

    @RequestMapping("/detail")
    public String detail(ModelMap map, Integer goodsId){
        if (goodsId != null && goodsId != 0){
            map.put("goodsId",goodsId);
        }
        return "goods/goods_detail";
    }

    @RequestMapping("/list")
    public String goodsList(){
        return "admin/goods/goods_list";
    }
}
