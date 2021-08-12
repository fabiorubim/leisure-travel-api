package br.com.leisuretravel.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
//@EnableFeignClients(basePackages = {"br.com.leisuretravel.cvcbackendhotel.client.http.hotels"})
//@ComponentScan(basePackages = { "br.com.leisuretravel.service", 
//								"br.com.leisuretravel.api.controller",
//								"br.com.leisuretravel.assembler"})					
//@ComponentScan(basePackages = {"br.com.leisuretravel.api.controller", "br.com.leisuretravel.service"})
@EnableRedisRepositories(basePackages = { "br.com.leisuretravel.repository" })
public class LeisureTravelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeisureTravelApiApplication.class, args);
	}
}
