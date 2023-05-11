package com.travelagency.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.database.RoomItem;
import com.travelagency.database.RoomsRepository;

@Service
public class RoomsServiceImplementation implements RoomsService{
	
	@Autowired
	RoomsRepository roomsRepository;
	
	public List<RoomItem> getAllRooms(){
		return roomsRepository.findAll();
	}
	
	public RoomItem getRoomById(int room_id) {
		return roomsRepository.findById(room_id).orElseThrow(()-> new RuntimeException("No data!"));
	}
	
	public RoomItem saveRoom(RoomItem ro) {
		return roomsRepository.save(ro);
	}

	public void deleteRoom(int room_id) {
		roomsRepository.deleteById(room_id);
	
	}
	
	public RoomItem updateRoom(RoomItem ro) {
		RoomItem roomItem = roomsRepository.findById(ro.getIdroom()).orElseThrow(() -> new RuntimeException("No data!"));
		roomItem.setPrice(ro.getPrice());
		roomItem.setCapacity(ro.getCapacity());
		roomItem.setBooked(ro.getBooked());
		roomItem.setHotel(ro.getHotel());
		roomsRepository.save(roomItem);
		return roomItem;
	}
	
	public List<RoomItem> lookUpRooms(String city, String capacity, String price)throws Exception{
		try {
			
			Collection<RoomItem> rooms = roomsRepository.lookUpRooms(city, capacity, price);
			
			return new ArrayList<>(rooms);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
