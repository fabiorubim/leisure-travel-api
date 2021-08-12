package br.com.leisuretravel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.leisuretravel.model.hotels.city.Hotel;

@Repository
public interface HotelRepository  extends CrudRepository<Hotel, String> {

}
