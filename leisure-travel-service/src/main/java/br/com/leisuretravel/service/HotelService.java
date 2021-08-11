package br.com.leisuretravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leisuretravel.assembler.HotelAssembler;
import br.com.leisuretravel.canonical.hotels.city.HotelResource;
import br.com.leisuretravel.cvcbackendhotel.client.http.hotels.HotelsClient;
import br.com.leisuretravel.model.hotels.city.Hotel;
import br.com.leisuretravel.repository.nosql.redis.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository repository;
	
	@Autowired
	private HotelsClient client;
	
	@Autowired
	private HotelAssembler assembler;
	
	public List<Hotel> getHotelsByCityId(String cityId) {
		
		  List<HotelResource> hotelsResource =
		  client.getHoteisPorCidade(cityId).getBody(); List<Hotel> entities =
		  assembler.toEntities(hotelsResource); repository.saveAll(entities);
		  
		  return (List<Hotel>) repository.findAll();
	}

}
