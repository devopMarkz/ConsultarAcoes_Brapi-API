package com.marcos.build_and_run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BuildAndRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildAndRunApplication.class, args);
	}

}
