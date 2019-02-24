package com.izmo.service.forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.izmo.service.forms.config.ApplicationConfig;
import com.izmo.service.forms.config.CacheConfig;

@SpringBootApplication
@EnableEurekaClient
@Import({ ApplicationConfig.class, CacheConfig.class })
@ComponentScan(basePackages = "com.izmo.core.forms")
public class FormsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormsApplication.class, args);
	}

}
