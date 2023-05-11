package com.travelagency.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelagency.database.HotelItem;
import com.travelagency.negocio.HotelsService;

@RestController
public class HotelsController {
	
	@Autowired
	private HotelsService hotelsService;
	
	@GetMapping("/hotels")
	public List<HotelItem> users(){
		return (List<HotelItem>) hotelsService.getAllHotels();
	}
	
	@GetMapping("/hotels/{hotel_id}")
    public HotelItem getRoomById(@PathVariable int hotel_id){
        return hotelsService.getHotelById(hotel_id);
    }
	
	@PostMapping("/hotels")
	public void insert(@RequestBody HotelItem ho) {
		hotelsService.saveHotel(ho);
		
	}
	
	@DeleteMapping(value="/hotels/{hotel_id}")
	public void delete (@PathVariable int hotel_id) {
		hotelsService.deleteHotel(hotel_id);
		
	}
	
	@PutMapping("/hotels")
	public void modify (@RequestBody HotelItem ho) {
		hotelsService.updateHotel(ho);
		
		
	}
}
