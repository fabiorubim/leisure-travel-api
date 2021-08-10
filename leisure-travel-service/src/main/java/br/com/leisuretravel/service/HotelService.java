package br.com.leisuretravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leisuretravel.repository.nosql.redis.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository repository;
	
	public void save() {
		
	}

}
