package br.com.leisuretravel.model.hotels.city;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {
	
	private BigDecimal adult;
	private BigDecimal child;
}
