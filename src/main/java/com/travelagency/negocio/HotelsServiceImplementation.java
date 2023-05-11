package com.travelagency.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.database.HotelItem;
import com.travelagency.database.HotelsRepository;

@Service
public class HotelsServiceImplementation implements HotelsService{
	
	@Autowired
	HotelsRepository hotelsRepository;
	
	@Override
	public List<HotelItem> getAllHotels(){
		return hotelsRepository.findAll();
	}
	
	@Override
	public HotelItem getHotelById(int hotel_id) {
		return hotelsRepository.findById(hotel_id).orElseThrow(()-> new RuntimeException("No data!"));
	}
	
	@Override
	public HotelItem saveHotel(HotelItem ho) {
		return hotelsRepository.save(ho);
	}
	
	@Override
	public void deleteHotel(int hotel_id) {
		hotelsRepository.deleteById(hotel_id);
	}
	
	@Override
	public HotelItem updateHotel(HotelItem ho) {
		HotelItem hotelItem = hotelsRepository.findById(ho.getIdHotel()).orElseThrow(() -> new RuntimeException("No data!"));
		hotelItem.setLogo(ho.getLogo());
		hotelItem.setHotelName(ho.getHotelName());
		hotelItem.setAddress(ho.getAddress());
		hotelItem.setCity(ho.getCity());
		hotelItem.setStars(ho.getStars());
		hotelItem.setWebsite(ho.getWebsite());
		hotelItem.setBookedTimes(ho.getBookedTimes());
		hotelsRepository.save(hotelItem);
		
		return hotelItem;
	}

}
