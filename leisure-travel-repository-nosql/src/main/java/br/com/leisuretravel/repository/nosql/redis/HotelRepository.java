package br.com.leisuretravel.repository.nosql.redis;

import org.springframework.data.repository.CrudRepository;

import br.com.leisuretravel.model.hotels.city.Hotel;

public interface HotelRepository  extends CrudRepository<Hotel, String> {

}
