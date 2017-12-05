package com.glory.shenghuo.controller.admin;

import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private GoodsService goodsService;

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
        return "admin/goods/goods_edit";
    }

    /**
     * 建材详情
     * @param map
     * @param goodsId
     * @return
     */
    @RequestMapping("/detail")
    public String detail(ModelMap map, Integer goodsId){
        if (goodsId != null && goodsId != 0){
            map.put("goodsId",goodsId);
        }
        return "admin/goods/goods_detail";
    }

    /**
     * 建材列表
     * @return
     */
    @RequestMapping("/list")
    public String goodsList(){
        return "admin/goods/goods_list";
    }

    /**
     * 获取商品详情Html
     * @param id
     * @return
     */
    @RequestMapping(value = "/getGoodsDetailHtml",method = RequestMethod.GET)
    public String getGoodsDetailHtml(ModelMap model,int id){
        GoodsPojo goodsPojo = goodsService.getGoodsById(id);
        if(goodsPojo!=null){
            model.put("goodsDetail",goodsPojo.getGoodsDetail());
        }else{
            model.put("goodsDetail","没有数据");
        }
        return "admin/goods/goodsdetail_html";
    }
}
