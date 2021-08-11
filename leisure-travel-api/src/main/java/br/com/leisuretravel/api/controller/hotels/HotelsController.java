package br.com.leisuretravel.api.controller.hotels;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<HotelResource>> getHotels(@PathVariable(value = "cityId") String cityId){
		List<Hotel> entities = service.getHotelsByCityId(cityId);
		
		return ok().body(assembler.toResources(entities));
	}

}
