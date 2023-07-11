package com.BWtest.lab.BW.runnable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.BWtest.lab.BW.entity.Booking;
import com.BWtest.lab.BW.entity.Companion;
import com.BWtest.lab.BW.repository.BookingRepository;
import com.BWtest.lab.BW.repository.CompanionRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BookingRunable implements CommandLineRunner{
	@Autowired
	private BookingRepository BRrepository;
	@Autowired
	private CompanionRepository CRrepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		AddData();
	}
	public void AddData() {
		Companion c1 = new Companion();
		c1.setName("阿忠");
		c1.setPhone("1");
		
		Companion c2 = new Companion();
		c2.setName("小美");
		c2.setPhone("2");
		
		Companion c3 = new Companion();
		c3.setName("A");
		c3.setPhone("3");
		
		Companion c4 = new Companion();
		c4.setName("B");
		c4.setPhone("4");
		
		Booking b1 = new Booking();
		b1.setName("阿明");
		b1.setPhone("0900");
		b1.setGeneration("11");
		b1.setCheckIn("4/21");
		b1.setCHeckOut("4/22");
		b1.setNumberOfPeople(2);
		b1.setYesNo(true);
		b1.addCompanion(c1);
		b1.addCompanion(c2);
		BRrepository.save(b1);
		
		
		Booking b2 = new Booking();
		b2.setName("yee");
		b2.setPhone("0912");
		b2.setGeneration("13");
		b2.setCheckIn("3/12");
		b2.setCHeckOut("3/13");
		b2.setNumberOfPeople(2);
		b2.setYesNo(false);
		b2.addCompanion(c3);
		b2.addCompanion(c4);
		BRrepository.save(b2);
		
		
	}

}
