package br.com.leisuretravel.repository.hotel.city;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.leisuretravel.model.hotels.city.Hotel;

@Repository
public interface HotelCityRepository  extends CrudRepository<Hotel, String> {

}
