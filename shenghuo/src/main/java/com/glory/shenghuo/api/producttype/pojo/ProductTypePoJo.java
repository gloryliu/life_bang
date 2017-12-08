package com.glory.shenghuo.api.producttype.pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductTypePoJo implements Serializable{

    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("父id")
    private int parentId;
    @ApiModelProperty("名称")
    private String text;
    @ApiModelProperty("是否删除")
    private int deleteFlag;
    @ApiModelProperty("是否叶子节点")
    private int isLeaf;

    private ArrayList<ProductTypePoJo> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public ArrayList<ProductTypePoJo> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ProductTypePoJo> children) {
        this.children = children;
    }

    public int getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(int isLeaf) {
        this.isLeaf = isLeaf;
    }
}
