package com.travelagency.negocio;

import java.util.List;
import com.travelagency.database.RoomItem;

public interface RoomsService {
	
	List<RoomItem> getAllRooms();
	RoomItem getRoomById(int room_id);

	RoomItem saveRoom(RoomItem us);
	void deleteRoom(int room_id);
	
	RoomItem updateRoom(RoomItem us);
	
	public List<RoomItem> lookUpRooms(String city, String capacity, String price) throws Exception;
}
