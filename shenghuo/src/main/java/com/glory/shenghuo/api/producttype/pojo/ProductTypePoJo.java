package com.glory.shenghuo.api.producttype.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductTypePoJo implements Serializable{

    private int id;
    private int parentId;
    private String text;
    private int deleteFlag;

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
}
