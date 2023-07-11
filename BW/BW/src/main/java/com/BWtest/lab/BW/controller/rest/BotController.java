package com.BWtest.lab.BW.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BWtest.lab.BW.entity.Booking;
import com.BWtest.lab.BW.repository.BookingRepository;
import com.BWtest.lab.BW.service.BookingService;
@CrossOrigin
@RestController
@RequestMapping("/robot")
public class BotController {
	@Autowired
	private BookingService service;
	
	@Autowired
	private BookingRepository repository;
	
	@GetMapping("/test"	)
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Hello JAVA", HttpStatus.OK);
	}
	@GetMapping("/all")
	public List<Booking> getAllBooking(){
		return service.GetTodayAllBooking();
	}
	@GetMapping("/{bookingId}")
	public Booking getBooking(@PathVariable(name="bookingId")Long id) {
		return service.GetBookingById(id);
	}
	@PostMapping("/")
	public void AddBooking(@RequestBody Booking booking) {
		service.AddBooking(booking);
	}
	@PostMapping("/requstyesno/{id}")
	public void modify(@PathVariable(name="id")Long id, @RequestBody Boolean yesno) {
		Booking b1 = repository.findById(id).orElseThrow();
		b1.setYesNo(yesno);
		service.AddBooking(b1);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name="id")Long id) {
		service.DeleteBooking(id);
	}
	
}
