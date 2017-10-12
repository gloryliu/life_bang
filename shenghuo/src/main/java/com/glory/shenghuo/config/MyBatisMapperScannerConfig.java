/**    
 * @Title: MyBatisMapperScannerConfig.java  
 * @Package com.marsplan.config
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author zhao.liang    
 * @date 2016年3月12日 下午1:57:30  
 * @version V1.0    
 */
package com.glory.shenghuo.config;

import com.glory.shenghuo.mapper.BaseMapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName: MyBatisMapperScannerConfig  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author zhao.liang  
 * @date 2016年3月12日 下午2:06:09  
 *
 */
@Configuration
//TODO 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
@AutoConfigureAfter({MyBatisSessionFactoryConfig.class})
public class MyBatisMapperScannerConfig {
	private static Logger logger = LoggerFactory.getLogger(MyBatisMapperScannerConfig.class);
	
    @Bean(name="mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
    	logger.info("Database Scanner File ~~~~~~~~~~~~~~~~~~~");
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(BaseMapper.class.getPackage().getName());
        mapperScannerConfigurer.setMarkerInterface(BaseMapper.class);
        return mapperScannerConfigurer;
    }
}
