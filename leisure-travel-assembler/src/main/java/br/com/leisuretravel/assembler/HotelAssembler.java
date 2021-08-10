package br.com.leisuretravel.assembler;

import org.mapstruct.Mapper;

import br.com.leisuretravel.canonical.hotels.city.HotelResource;
import br.com.leisuretravel.model.hotels.city.Hotel;

@Mapper(componentModel = "spring")
public interface HotelAssembler {
	
    Hotel toEntity(HotelResource resource);
	
    HotelResource toResource(Hotel entity);

}
