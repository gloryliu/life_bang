package com.glory.shenghuo.service.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.StringUtil;
import com.glory.shenghuo.api.producttype.pojo.ProductTypePoJo;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    /**
     * 添加菜单
     * @param param
     * @return
     */
    public ResponseEntity<Object> add(ProductTypePoJo param){

        if(productTypeMapper.add(param)>0){
            return MyResponseUtil.ok("添加成功");
        }else {
            return MyResponseUtil.error("添加失败");
        }
    }

    /**
     * 更新菜单
     * @param param
     * @return
     */
    public ResponseEntity<Object> update(ProductTypePoJo param){

        if(productTypeMapper.update(param)>0){
            return MyResponseUtil.ok("更新成功");
        }else{
            return MyResponseUtil.error("更新失败");
        }
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    public ResponseEntity<Object> delete(int id){

        if(productTypeMapper.delete(id)>0){
            return MyResponseUtil.ok("删除成功");
        }else{
            return MyResponseUtil.error("删除失败");
        }
    }

    /**
     * 获取菜单
     * @return
     */
    public ResponseEntity<Object> getTypeList(){

        ProductTypePoJo topMenu = new ProductTypePoJo();
        topMenu.setId(0);
        topMenu.setParentId(0);
        topMenu.setText("分类列表");

        ArrayList<ProductTypePoJo> rootMenu = productTypeMapper.getAllList(0);

        ArrayList<ProductTypePoJo> menuList = new ArrayList<>();

        for (int i=0;i<rootMenu.size();i++){
            if(rootMenu.get(i).getParentId()==0){
                menuList.add(rootMenu.get(i));
            }
        }

        for (ProductTypePoJo menu:menuList) {
            menu.setChildren(getChild(menu.getId(),rootMenu));
        }

        topMenu.setChildren(menuList);

        return new ResponseEntity<Object>(topMenu, HttpStatus.OK);
    }

    /**
     * 添加商品时选择分类
     * @return
     */
    public String getSelectDomList(int type){

        ArrayList<ProductTypePoJo> rootMenu = productTypeMapper.getAllList(type);

        ArrayList<ProductTypePoJo> menuList = new ArrayList<>();

        for (int i=0;i<rootMenu.size();i++){
            if(rootMenu.get(i).getParentId()==0){
                menuList.add(rootMenu.get(i));
            }
        }

        for (ProductTypePoJo menu:menuList) {
            menu.setChildren(getChild(menu.getId(),rootMenu));
        }


        String json = JSON.toJSONString(menuList);
        if(StringUtil.isNotEmpty(json)){
            json = json.replaceAll("id","v")
                    .replaceAll("text","n")
                    .replaceAll("children","s");
        }

        return json;
    }

    /**
     * 递归获取子菜单
     * @param id
     * @param rootMenu
     * @return
     */
    private ArrayList<ProductTypePoJo> getChild(int id,ArrayList<ProductTypePoJo> rootMenu){

        ArrayList<ProductTypePoJo> childList = new ArrayList<>();

        for (ProductTypePoJo menu:rootMenu) {
            if(menu.getParentId()==id){
                childList.add(menu);
            }
        }

        for (ProductTypePoJo menu:childList) {
            if(menu.getIsLeaf()==0){
                menu.setChildren(getChild(menu.getId(),rootMenu));
            }
        }

        if(childList.size()==0){
            return null;
        }

        return childList;
    }

}
