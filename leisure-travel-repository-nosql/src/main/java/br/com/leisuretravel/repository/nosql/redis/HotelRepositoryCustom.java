package br.com.leisuretravel.repository.nosql.redis;

import br.com.leisuretravel.model.hotels.city.Hotel;

public interface HotelRepositoryCustom {

	Hotel findByCityId(String cityId);
}
