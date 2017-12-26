package com.glory.shenghuo;

import com.glory.shenghuo.api.pay.bean.PayNetBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties({PayNetBean.class})
public class ShenghuoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ShenghuoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ShenghuoApplication.class, args);
	}
}
