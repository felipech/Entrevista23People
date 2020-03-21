package com.ejem.mircroservice.cursomicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("resourse")
@ComponentScan(basePackages = {"resourse"})
@EntityScan("resourse")
public class CursoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoMicroserviceApplication.class, args);
	}

}
