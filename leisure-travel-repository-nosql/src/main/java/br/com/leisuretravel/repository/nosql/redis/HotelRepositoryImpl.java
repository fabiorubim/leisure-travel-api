package br.com.leisuretravel.repository.nosql.redis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import br.com.leisuretravel.model.hotels.city.Hotel;

@Repository
public class HotelRepositoryImpl implements HotelRepositoryCustom {

	private RedisTemplate<String, Hotel> redisTemplate;
	private HashOperations hashOperations;
	
	public HotelRepositoryImpl(RedisTemplate<String, Hotel> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }
	
	@Override
	public Hotel findByCityId(String cityId) {
		return (Hotel)hashOperations.get("ID",cityId);
	}
}
