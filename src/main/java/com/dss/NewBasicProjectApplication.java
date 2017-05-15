package com.dss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.dss.basicproject.model.SeasonEntity;
import com.dss.basicproject.service.MasterService;

@SpringBootApplication
@ComponentScan(basePackages="com.dss.basicproject")
public class NewBasicProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(NewBasicProjectApplication.class, args);
		
	}
}
