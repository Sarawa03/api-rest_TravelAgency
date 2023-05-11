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

import com.travelagency.database.BookingItem;
import com.travelagency.negocio.BookingsService;


@RestController
public class BookingsController {
	
	@Autowired
	BookingsService bookingsService;

    @GetMapping("/bookings")
    public List<BookingItem> allBookings(){
        return bookingsService.getAllBookings();
    }
    
    @GetMapping("/bookings/hotelsinrange")
    public ResponseEntity<?> hotelsInRange(@RequestParam String dateCheckIn, @RequestParam String dateCheckOut){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(bookingsService.hotelsInRange(dateCheckIn, dateCheckOut));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\" : \""+ e.getMessage() + "\"}"));
		}
	}

    @GetMapping("/bookings/{booking_id}")
    public BookingItem getBookingById(@PathVariable int booking_id){
        return bookingsService.getBookingById(booking_id);
    }


    @PostMapping("/bookings")
    public BookingItem insert(@RequestBody BookingItem bo){
        return bookingsService.saveBooking(bo);
    }


    @DeleteMapping("/bookings/{booking_id}")
    public void delete(@PathVariable int booking_id){
    	bookingsService.deleteBooking(booking_id);
    }

    @PutMapping("/bookings")
    public BookingItem modify( @RequestBody BookingItem bo){
        return  bookingsService.updateBooking(bo);
    }
}
