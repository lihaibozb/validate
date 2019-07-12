package com.zyxfcfc.validate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @apiNote 
 * @author lihaibo
 * @date 2019/7/9 4:15 PM 
 * @version 1.0.0
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan("com.zyxfcfc.validate.generator.dao")
@Slf4j
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableConfigurationProperties
public class ValidateApplication {

	//TODO sharding-jdbc无效
	public static void main(String[] args) {
		new SpringApplicationBuilder(ValidateApplication.class).web(WebApplicationType.SERVLET).run(args);
		//test grep console
		log.debug("debug信息：开始启动....");
		log.info("info信息：开始启动....");
		log.warn("warn信息：开始启动....");
		log.error("error信息：开始启动....");
		log.trace("trace信息：开始启动....");
		//SpringApplication.run(ValidateApplication.class, args);
	}

}
