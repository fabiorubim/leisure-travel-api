package br.com.leisuretravel.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
//@EnableFeignClients(basePackages = {"br.com.leisuretravel.cvcbackendhotel.client.http.hotels"})
//@ComponentScan(basePackages = { "br.com.leisuretravel.service", 
//								"br.com.leisuretravel.api.controller",
//								"br.com.leisuretravel.assembler"})					
@EnableRedisRepositories(basePackages = { "br.com.leisuretravel.repository.nosql.redis" })
@ComponentScan(basePackages = {"br.com.leisuretravel.api.controller"})
public class LeisureTravelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeisureTravelApiApplication.class, args);
	}

}
