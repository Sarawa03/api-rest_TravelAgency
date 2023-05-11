package com.travelagency.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelagency.database.RoomItem;
import com.travelagency.negocio.RoomsService;

@RestController
public class RoomsController {
	
	@Autowired
	private RoomsService roomsService;
	
	@GetMapping("/rooms")
	public List<RoomItem> users(){
		return (List<RoomItem>) roomsService.getAllRooms();
	}
	
	
	@GetMapping("rooms/lookup")
	public ResponseEntity<?> lookUpRoom(@RequestParam String city, @RequestParam String capacity, @RequestParam String price){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(roomsService.lookUpRooms(city,capacity,price));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\" : \""+ e.getMessage() + "\"}"));
		}
	}
	
	@GetMapping("/rooms/{room_id}")
    public RoomItem getRoomById(@PathVariable int room_id){
        return roomsService.getRoomById(room_id);
    }
	
	@PostMapping("/rooms")
	public void insert(@RequestBody RoomItem ro) {
		roomsService.saveRoom(ro);
		
	}
	
	@DeleteMapping(value="/rooms/{room_id}")
	public void delete (@PathVariable int room_id) {
		roomsService.deleteRoom(room_id);
		
	}
	
	@PutMapping("/rooms")
	public void modify (@RequestBody RoomItem ro) {
		roomsService.updateRoom(ro);
		
		
	}

}
