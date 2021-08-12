package br.com.leisuretravel.repository;

import br.com.leisuretravel.model.hotels.city.Hotel;

public class HotelRepositoryImpl implements HotelRepositoryCustom {

//	private RedisTemplate<String, Hotel> redisTemplate;
//	private HashOperations hashOperations;
//	
//	public HotelRepositoryImpl(RedisTemplate<String, Hotel> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//        hashOperations = redisTemplate.opsForHash();
//    }
	
	@Override
	public Hotel findByCityId(String cityId) {
//		return (Hotel)hashOperations.get("ID",cityId);
		return null;
	}
}
