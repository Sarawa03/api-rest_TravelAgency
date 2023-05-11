package com.travelagency.database;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends JpaRepository<BookingItem, Integer>{

	
	@Query(value = "SELECT b FROM BookingItem b WHERE ((b.initialDate >= :dateCheckIn AND b.initialDate <= :dateCheckOut) OR (b.endDate >= :dateCheckIn AND b.endDate <= :dateCheckOut) OR (b.initialDate < :dateCheckIn AND b.endDate > :dateCheckOut))")
	public Collection<BookingItem> hotelsInRange(@Param("dateCheckIn") String dateCheckIn, @Param("dateCheckOut") String dateCheckOut);
}
