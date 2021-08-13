package br.com.leisuretravel.api.controller.hotels;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leisuretravel.assembler.HotelAssembler;
import br.com.leisuretravel.canonical.hotels.city.HotelResource;
import br.com.leisuretravel.model.hotels.city.Hotel;
import br.com.leisuretravel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelsController {
	
	@Autowired
	private HotelService service;

	@Autowired
	private HotelAssembler assembler;
	
	@GetMapping(value = "/city/{cityId}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HotelResource>> getHotels(@PathVariable(value = "cityId") String cityId,
														 @RequestHeader(value = "checkInDate") @DateTimeFormat(pattern = "yyyy-MM-dd") DateTime checkInDate, 
														 @RequestHeader(value = "checkOutDate") @DateTimeFormat(pattern = "yyyy-MM-dd") DateTime checkOutDate,
														 @RequestHeader(value = "numberOfAdults") int numberOfAdults,
														 @RequestHeader(value = "numberOfChildren") int numberOfChildren){
		List<Hotel> entities = service.getHotelsByCityId(cityId, checkInDate, checkOutDate, numberOfAdults, numberOfChildren);
		
		return ok().body(assembler.toResources(entities));
	}
	
	@GetMapping
	public ResponseEntity<String> getTeste(){
		Hotel hotel = new Hotel();
		hotel.setCityCode(15);
		hotel.setCityName("Sorocaba");
		hotel.setName("SorocabaPark");
		hotel.setId(1);
        service.save(hotel);		
		return ok().body("Olá");
	}
}
