package br.com.leisuretravel.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leisuretravel.assembler.HotelAssembler;
import br.com.leisuretravel.cvcbackendhotel.client.http.hotels.HotelsClient;
import br.com.leisuretravel.repository.HotelRepository;

@Service
public class HotelService {
	
	private static final BigDecimal COMISSION =  new BigDecimal(70);
	public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
	
	@Autowired
	private HotelRepository repository;
	
	@Autowired
	private HotelsClient client;
	
	@Autowired
	private HotelAssembler assembler;
//	
//	public List<Hotel> getHotelsByCityId(String cityId, DateTime checkInDate, DateTime checkOutDate, int numberOfAdults, int numberOfChildren) {
//		
//		  List<HotelResource> hotelsResource = client.getHoteisPorCidade(cityId).getBody(); 
//		  List<Hotel> entities = assembler.toEntities(hotelsResource); 
//		  repository.saveAll(entities);
//		  
//		  
//		  
//		  BigDecimal daysBetween = new BigDecimal(Math.abs(Days.daysBetween(checkInDate, checkOutDate).getDays()));
//		  BigDecimal totalAdult = entities.get(0).getRooms().get(0).getPrice().getAdult().multiply(new BigDecimal(numberOfAdults));
//		  BigDecimal totalChildren = entities.get(0).getRooms().get(0).getPrice().getChild().multiply(new BigDecimal(numberOfChildren));
//		  
//		  BigDecimal totalPrice = totalAdult.add(totalChildren).multiply(daysBetween);				  
//		  totalPrice.multiply(COMISSION).divide(ONE_HUNDRED);
//		  
//		  
//		  return (List<Hotel>) repository.findAll();
//	}

}
