package br.com.leisuretravel.service;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.leisuretravel.assembler.HotelAssembler;
import br.com.leisuretravel.canonical.hotels.city.HotelResource;
import br.com.leisuretravel.cvcbackendhotel.client.http.hotels.HotelsClient;
import br.com.leisuretravel.model.hotels.city.Hotel;
import br.com.leisuretravel.repository.HotelRepository;

@Service
public class HotelService {

	private static final BigDecimal COMISSION = new BigDecimal(70);
	public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

	@Autowired
	@Lazy
	private HotelRepository repository;

	@Autowired
	private HotelsClient client;

	@Autowired
	private HotelAssembler assembler;

	public void save(Hotel entity) {
		List<HotelResource> hotelsResource = client.getHoteisPorCidade("1032").getBody();
		List<Hotel> entities = assembler.toEntities(hotelsResource);
		repository.saveAll(entities);
	}

//	@Cacheable(value = "getHotelsByCityId")
	public List<Hotel> getHotelsByCityId(String cityId, DateTime checkInDate, DateTime checkOutDate, int numberOfAdults, int numberOfChildren) {

		List<Hotel> hotelsFromDB = (List<Hotel>) repository.findAll();
		if (!hotelsFromDB.isEmpty() & !hotelsFromDB.contains(null)) {
			return hotelsFromDB;
		}

		List<HotelResource> hotelsResource = client.getHoteisPorCidade(cityId).getBody();
		List<Hotel> entities = assembler.toEntities(hotelsResource);
		repository.saveAll(entities);

//		  BigDecimal daysBetween = new BigDecimal(Math.abs(Days.daysBetween(checkInDate, checkOutDate).getDays()));
//		  BigDecimal totalAdult = entities.get(0).getRooms().get(0).getPrice().getAdult().multiply(new BigDecimal(numberOfAdults));
//		  BigDecimal totalChildren = entities.get(0).getRooms().get(0).getPrice().getChild().multiply(new BigDecimal(numberOfChildren));
//		  
//		  BigDecimal totalPrice = totalAdult.add(totalChildren).multiply(daysBetween);				  
//		  totalPrice.multiply(COMISSION).divide(ONE_HUNDRED);

		return (List<Hotel>) repository.findAll();
	}

}
