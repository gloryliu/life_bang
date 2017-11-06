package com.glory.shenghuo.api.service.pojo;

import java.io.Serializable;

public class ServicePojo implements Serializable {

    //主键
    private int id;

    //服务名称
    private String serviceName;

    //服务价格
    private int servicePrice;

    //服务类型
    private int serviceType;

    //是否广告位展示
    private int isBanner;

    //服务详情
    private String serviceDetail;

    //服务图片
    private String serviceImg;

    //考察类型
    private int seeType;

    //是否推荐服务
    private int isRec;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getIsBanner() {
        return isBanner;
    }

    public void setIsBanner(int isBanner) {
        this.isBanner = isBanner;
    }

    public String getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    public String getServiceImg() {
        return serviceImg;
    }

    public void setServiceImg(String serviceImg) {
        this.serviceImg = serviceImg;
    }

    public int getSeeType() {
        return seeType;
    }

    public void setSeeType(int seeType) {
        this.seeType = seeType;
    }

    public int getIsRec() {
        return isRec;
    }

    public void setIsRec(int isRec) {
        this.isRec = isRec;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }
}
