package com.glory.shenghuo.api.goods.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-06 14:01
 **/
public class AppGetDataListParam implements Serializable {

    @ApiModelProperty("当前页")
    private int pageNum;


    @ApiModelProperty("每页条数")
    private int pageSize;


    @ApiModelProperty("关键字")
    private String keyWord;


    @ApiModelProperty("数据类型 1为建材、2为服务")
    private int type;


    @ApiModelProperty("分类")
    private int classify;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }
}
