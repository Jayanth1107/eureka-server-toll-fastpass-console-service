package com.jayanth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaServerTollFastpassConsoleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerTollFastpassConsoleServiceApplication.class, args);
	}

}
