package br.com.leisuretravel.api.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisKeyValueAdapter.EnableKeyspaceEvents;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@SpringBootApplication//(scanBasePackages =  "br.com.leisuretravel.api.controller")
//@EnableFeignClients(basePackages = { "br.com.leisuretravel.cvcbackendhotel.client" })
@ComponentScan(basePackages = {"br.com.leisuretravel.api.controller", 
							   "br.com.leisuretravel.service",  
							   "br.com.leisuretravel.assembler",
							   "br.com.leisuretravel"})
@EnableRedisRepositories(basePackages = "br.com.leisuretravel.repository", enableKeyspaceEvents = EnableKeyspaceEvents.ON_STARTUP)
public class LeisureTravelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeisureTravelApiApplication.class, args);
	}
	
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	
	@Bean
	public CacheManager redisCacheManager() {
		RedisSerializationContext.SerializationPair<Object> jsonSerializer = RedisSerializationContext.SerializationPair
				.fromSerializer(new GenericJackson2JsonRedisSerializer());
		return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory)
				.cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(jsonSerializer))
				.build();
	}
}
