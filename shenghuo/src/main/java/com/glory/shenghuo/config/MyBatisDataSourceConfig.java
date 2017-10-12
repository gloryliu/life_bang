/**    
 * @Title: DataBaseConfiguration.java  
 * @Package com.marsplan.config
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author zhao.liang    
 * @date 2016年3月12日 下午1:25:51  
 * @version V1.0    
 */
package com.glory.shenghuo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

@Configuration
public class MyBatisDataSourceConfig implements EnvironmentAware {

	private RelaxedPropertyResolver propertyResolver;

	private static Logger log = LoggerFactory.getLogger(MyBatisDataSourceConfig.class);

	@Override
	public void setEnvironment(Environment env) {
		this.propertyResolver = new RelaxedPropertyResolver(env, "spring.dataSource.");
	}

	@Bean(name = "dataSource")
	@Primary
	public DataSource dataSource() {
		log.debug("Configruing Write DataSource");

		HikariConfig datasource = new HikariConfig();
		datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
		datasource.setJdbcUrl(propertyResolver.getProperty("url"));
		datasource.setUsername(propertyResolver.getProperty("username"));
		datasource.setPassword(propertyResolver.getProperty("password"));
		datasource.setPoolName("dataSourcePool");
		
		datasource.addDataSourceProperty("cachePrepStmts", "true");
		datasource.addDataSourceProperty("prepStmtCacheSize", "256");
		datasource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		datasource.addDataSourceProperty("useServerPrepStmts", "true");

		datasource.setConnectionTimeout(TimeUnit.MINUTES.toMillis(30));
		datasource.setValidationTimeout(TimeUnit.SECONDS.toMillis(15));
		
		datasource.setAutoCommit(false);
		datasource.setMinimumIdle(5);
		datasource.setMaximumPoolSize(30);
		datasource.setConnectionInitSql("SELECT 1");
		return new HikariDataSource(datasource);
	}


}
