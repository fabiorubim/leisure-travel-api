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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/hotels")
@Api(tags = {"Leisure Travel API"})
public class HotelsController {
	
	@Autowired
	private HotelService service;

	@Autowired
	private HotelAssembler assembler;
	
	@ApiOperation(value = "Efetua uma busca pelo código da cidade.", 
                  response = HotelResource.class)
	@GetMapping(value = "/city/{cityId}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HotelResource>> getHotelsByCityId(
													     @ApiParam(name = "cityId", type = "String", value = "Código da cidade", required = true)
														 @PathVariable(value = "cityId") String cityId,
														 @ApiParam(name = "checkInDate", type = "Date", value = "Data de CheckIn", required = true)
														 @RequestHeader(value = "checkInDate") @DateTimeFormat(pattern = "yyyy-MM-dd") DateTime checkInDate,
														 @ApiParam(name = "checkOutDate", type = "Date", value = "Data de CheckOut", required = true)
														 @RequestHeader(value = "checkOutDate") @DateTimeFormat(pattern = "yyyy-MM-dd") DateTime checkOutDate,
														 @ApiParam(name = "numberOfAdults", type = "String", value = "Quantidade de adultos", required = true)
														 @RequestHeader(value = "numberOfAdults") int numberOfAdults,
														 @ApiParam(name = "numberOfChildren", type = "String", value = "Quantidade de crianças", required = true)
														 @RequestHeader(value = "numberOfChildren") int numberOfChildren){
		List<Hotel> entities = service.getHotelsByCityId(cityId, checkInDate, checkOutDate, numberOfAdults, numberOfChildren);
		
		return ok().body(assembler.toResources(entities));
	}
	
	@ApiOperation(value = "Efetua uma buasca pelo código do hotel.", 
            response = HotelResource.class)
	@GetMapping(value = "/{hotelId}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelResource> getByHotelId(
													     @ApiParam(name = "hotelId", type = "String", value = "Código do hotel", required = true)
													     @PathVariable(value = "hotelId") String hotelId,
														 @ApiParam(name = "checkInDate", type = "Date", value = "Data de CheckIn", required = true)
														 @RequestHeader(value = "checkInDate") @DateTimeFormat(pattern = "yyyy-MM-dd") DateTime checkInDate,
														 @ApiParam(name = "checkOutDate", type = "Date", value = "Data de CheckOut", required = true)
														 @RequestHeader(value = "checkOutDate") @DateTimeFormat(pattern = "yyyy-MM-dd") DateTime checkOutDate,
														 @ApiParam(name = "numberOfAdults", type = "String", value = "Quantidade de adultos", required = true)
														 @RequestHeader(value = "numberOfAdults") int numberOfAdults,
														 @ApiParam(name = "numberOfChildren", type = "String", value = "Quantidade de crianças", required = true)
														 @RequestHeader(value = "numberOfChildren") int numberOfChildren){
		Hotel entity = service.getByHotelId(hotelId, checkInDate, checkOutDate, numberOfAdults, numberOfChildren);
		
		return ok().body(assembler.toResource(entity));
	}
	
}
