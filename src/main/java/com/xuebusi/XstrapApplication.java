package com.xuebusi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class})
@ServletComponentScan
@EnableScheduling
@EnableTransactionManagement
@EnableCaching
@EnableAsync
public class XstrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(XstrapApplication.class, args);
	}
}
