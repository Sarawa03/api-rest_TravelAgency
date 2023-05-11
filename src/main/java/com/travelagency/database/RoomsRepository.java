package com.travelagency.database;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<RoomItem, Integer>{

	@Query(value = "SELECT r FROM RoomItem r JOIN HotelItem h on h.idHotel= r.hotel WHERE h.city LIKE %:c% AND r.capacity < :capacity AND r.price < :price")
	public Collection<RoomItem> lookUpRooms(@Param("c") String city, @Param("capacity") String capacity, @Param("price") String price);
	
	/*@Query(value = "SELECT r FROM RoomItem r JOIN HotelItem h on h.idHotel= r.hotel WHERE h.city LIKE %:c%")
	public Collection<RoomItem> lookUpRooms(@Param("c") String city);*/
	
	

}
