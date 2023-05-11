package com.travelagency.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.database.BookingItem;
import com.travelagency.database.BookingsRepository;

@Service
public class BookingsServiceImplementation implements BookingsService{
	
	@Autowired
	BookingsRepository bookingsRepository; 
	
	@Override
	public List<BookingItem> getAllBookings(){
		return bookingsRepository.findAll();
	}
	
	@Override
	public BookingItem getBookingById(int booking_id) {
		return bookingsRepository.findById(booking_id).orElseThrow(()-> new RuntimeException("No data!"));
	}
	
	@Override
	public BookingItem saveBooking(BookingItem bo) {
		return bookingsRepository.save(bo);
	}
	
	@Override
	public void deleteBooking(int booking_id) {
		bookingsRepository.deleteById(booking_id);
	}
	
	@Override
	public BookingItem updateBooking(BookingItem bo) {
		BookingItem bookingItem = bookingsRepository.findById(bo.getIdbooking()).orElseThrow(() -> new RuntimeException("No data!"));
		bookingItem.setIduser(bo.getIduser());
		bookingItem.setIdroom(bo.getIdroom());
		bookingItem.setInitialDate(bo.getInitialDate());
		bookingItem.setEndDate(bo.getEndDate());
		bookingsRepository.save(bo);
		return bookingItem;
		
	}
	
	@Override
	public List<BookingItem> hotelsInRange(String dateCheckIn, String dateCheckOut)throws Exception{
		try {
			
			Collection<BookingItem> bookings = bookingsRepository.hotelsInRange(dateCheckIn, dateCheckOut);
			
			return new ArrayList<>(bookings);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
