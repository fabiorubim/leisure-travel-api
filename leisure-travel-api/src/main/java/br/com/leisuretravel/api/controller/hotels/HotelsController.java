package br.com.leisuretravel.api.controller.hotels;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leisuretravel.assembler.HotelAssembler;
import br.com.leisuretravel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelsController {
	
	@Autowired
	private HotelService service;

	@Autowired
	private HotelAssembler assembler;
	
	@GetMapping
	public ResponseEntity<String> getTeste(){
		return ok().body("Olá");
	}
}
