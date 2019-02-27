package com.izmo.services.formbuilder.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.izmo.services.formbuilder.config.PersistenceConfig;

@SpringBootApplication
@EnableEurekaClient
@Import({ PersistenceConfig.class})
@ComponentScan(basePackages = {"com.izmo.core","com.izmo.services"})
public class FormBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormBuilderApplication.class, args);
	}

}
