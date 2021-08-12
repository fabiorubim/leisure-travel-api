package br.com.leisuretravel.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication//(scanBasePackages =  "br.com.leisuretravel.api.controller")
@EnableFeignClients(basePackages = { "br.com.leisuretravel.cvcbackendhotel.client" })
@ComponentScan(basePackages = {"br.com.leisuretravel.api.controller", 
							   "br.com.leisuretravel.service",  
							   "br.com.leisuretravel.assembler"})
@EnableRedisRepositories(basePackages = "br.com.leisuretravel.repository")
public class LeisureTravelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeisureTravelApiApplication.class, args);
	}

}
