package com.glory.shenghuo.api.pay.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "paynet",locations = "classpath:/paynet/paynet.properties")
public class PayNetBean {
    private String alinet;

    public String getAlinet() {
        return alinet;
    }

    public void setAlinet(String alinet) {
        this.alinet = alinet;
    }
}
