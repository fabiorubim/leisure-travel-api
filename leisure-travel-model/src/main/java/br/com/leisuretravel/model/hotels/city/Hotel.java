package br.com.leisuretravel.model.hotels.city;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.redis.core.RedisHash;

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
@RedisHash(value = "Hotel", timeToLive = Hotel.TEMPO_EXPIRACAO)
public class Hotel implements Serializable {
	
	public static final long TEMPO_EXPIRACAO= 10;

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer cityCode;
	private String cityName;
	private List<Room> rooms;
}
