package br.com.leisuretravel.service;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.leisuretravel.assembler.HotelAssembler;
import br.com.leisuretravel.canonical.hotels.city.HotelResource;
import br.com.leisuretravel.cvcbackendhotel.client.http.hotels.HotelsClient;
import br.com.leisuretravel.model.hotels.city.Hotel;
import br.com.leisuretravel.repository.hotel.city.HotelCityRepository;
import br.com.leisuretravel.repository.hotel.unique.HotelUniqueRepository;

@Service
public class HotelService {

	private static final BigDecimal COMISSION = new BigDecimal(0.7);

	@Autowired
	@Lazy
	private HotelCityRepository repositoryHotelCity;
	
	@Autowired
	@Lazy
	private HotelUniqueRepository repositoryHotelUnique;

	@Autowired
	private HotelsClient client;

	@Autowired
	private HotelAssembler assembler;

//	@Cacheable(value = "getHotelsByCityId")
	public List<Hotel> getHotelsByCityId(String cityId, DateTime checkInDate, DateTime checkOutDate, int numberOfAdults, int numberOfChildren) {
		List<Hotel> hotelsFromDB = (List<Hotel>) repositoryHotelCity.findAll();
		if (hotelsFromDB.isEmpty() | hotelsFromDB.contains(null)) {
			List<HotelResource> hotelsResource = client.getHoteisPorCidade(cityId).getBody();
			List<Hotel> entities = assembler.toEntities(hotelsResource);
			repositoryHotelCity.saveAll(entities);
		}		
		List<Hotel> hotels = (List<Hotel>) repositoryHotelCity.findAll();
		for (Hotel hotel : hotels) {
			BigDecimal totalPrice = dailyCharge(hotel, checkInDate, checkOutDate, numberOfAdults, numberOfChildren);
			hotel.setTotalPrice(totalPrice);
		}
		return hotels;
	}
	
	public Hotel getByHotelId(String hotelId, DateTime checkInDate, DateTime checkOutDate, int numberOfAdults, int numberOfChildren) {
		Hotel hotel;
		hotel = repositoryHotelUnique.findById(hotelId).orElse(null);
		if (hotel == null) {
			List<HotelResource> hotelsResource = client.getDetalhesHotel(hotelId).getBody();
			List<Hotel> entities = assembler.toEntities(hotelsResource);
			repositoryHotelUnique.saveAll(entities);
		}		
		hotel = repositoryHotelUnique.findById(hotelId).orElse(null);
		BigDecimal totalPrice = dailyCharge(hotel, checkInDate, checkOutDate, numberOfAdults, numberOfChildren);		  
	    hotel.setTotalPrice(totalPrice);		 
		return hotel;				
	}
	
	private BigDecimal dailyCharge(Hotel hotel, DateTime checkInDate, DateTime checkOutDate, int numberOfAdults, int numberOfChildren) {
		BigDecimal daysBetween = new BigDecimal(Math.abs(Days.daysBetween(checkInDate, checkOutDate).getDays()));
	    BigDecimal totalAdult = hotel.getRooms().get(0).getPrice().getAdult().multiply(new BigDecimal(numberOfAdults));
	    BigDecimal totalChildren = hotel.getRooms().get(0).getPrice().getChild().multiply(new BigDecimal(numberOfChildren));
  	    BigDecimal totalPrice = totalAdult.add(totalChildren).multiply(daysBetween);				  
	    totalPrice = totalPrice.multiply(COMISSION).add(totalPrice).setScale(2, BigDecimal.ROUND_HALF_EVEN);	    
	    return totalPrice;
	}

}
