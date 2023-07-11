package com.BWtest.lab.BW.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BWtest.lab.BW.entity.Booking;
import com.BWtest.lab.BW.entity.Companion;
import com.BWtest.lab.BW.repository.BookingRepository;
@Service
public class BookingServiceImplement implements BookingService{
	@Autowired
	private BookingRepository repository;
	
	
	@Override
	//先寫回傳全部 之後再改成今天
	public List<Booking> GetTodayAllBooking() {
		Iterable<Booking> findall = repository.findAll();
		List<Booking> allbooking = new ArrayList<>();
		findall.forEach(allbooking::add);
		return allbooking;
	}

	@Override
	public Booking GetBookingById(Long BookingId) {
		Booking b = repository.findById(BookingId).get();
		return b;
	}

	@Override
	public void AddBooking(Booking been) {
		for (Companion companion : been.getCompanion()) {
            companion.setBooking(been);
        }
		repository.save(been);
	}

	@Override
	public void DeleteBooking(Long BookingId) {
		repository.deleteById(BookingId);
	}

}
