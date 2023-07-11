package com.BWtest.lab.BW.service;

import java.util.List;

import com.BWtest.lab.BW.entity.Booking;

public interface BookingService {
	//不給修改
	List<Booking> GetTodayAllBooking();
	Booking GetBookingById(Long BookingId);
	void AddBooking(Booking been);
	void DeleteBooking(Long BookingId);
}
