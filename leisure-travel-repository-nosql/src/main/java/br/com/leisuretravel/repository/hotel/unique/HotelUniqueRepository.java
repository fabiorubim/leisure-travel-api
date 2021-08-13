package br.com.leisuretravel.repository.hotel.unique;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.leisuretravel.model.hotels.city.Hotel;

@Repository
public interface HotelUniqueRepository  extends CrudRepository<Hotel, String> {

}
