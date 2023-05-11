package com.travelagency.negocio;

import java.util.List;

import com.travelagency.database.BookingItem;

public interface BookingsService {
	List<BookingItem> getAllBookings();
	BookingItem getBookingById(int booking_id);
	
	BookingItem saveBooking(BookingItem bo);
	void deleteBooking(int booking_id);
	
	BookingItem updateBooking(BookingItem bo);
	
	public List<BookingItem> hotelsInRange(String dateCheckIn, String dateCheckOut) throws Exception;
}
