package com.travelagency.negocio;

import java.util.List;

import com.travelagency.database.HotelItem;

public interface HotelsService {
	List<HotelItem> getAllHotels();
	HotelItem getHotelById(int hotel_id);
	
	HotelItem saveHotel(HotelItem ho);
	void deleteHotel(int hotel_id);
	
	HotelItem updateHotel(HotelItem ho);
}
