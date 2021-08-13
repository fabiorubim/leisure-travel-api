package br.com.leisuretravel.model.hotels.city;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"cityCode", "id"})
@RedisHash(value = "Hotel", timeToLive = Hotel.TEMPO_EXPIRACAO)
public class Hotel implements Serializable {
	
	public static final long TEMPO_EXPIRACAO= 60;

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	private Integer cityCode;
	private String cityName;
	private List<Room> rooms;
	private BigDecimal totalPrice;
}
