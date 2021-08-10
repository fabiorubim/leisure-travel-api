package br.com.leisuretravel.model.hotels.city;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
	
	private Integer id;
	private String name;
	private Integer cityCode;
	private String cityName;
	private List<Room> rooms;
}
