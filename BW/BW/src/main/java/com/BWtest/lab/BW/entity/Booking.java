package com.BWtest.lab.BW.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Name;
	private String phone;
	private String Generation;
	private String CheckIn;
	private String CHeckOut;//take out
	private Integer NumberOfPeople;//take out
	private Boolean YesNo;
	//need a p.s.
	
	@OneToMany(mappedBy = "booking",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER, orphanRemoval = true)
	
	private List<Companion> companion = new ArrayList<>();
	public void addCompanion(Companion rt1) {
		companion.add(rt1);
		rt1.setBooking(this);
	}
	public void RandomLongId() {
		Random rand = new Random();
		long randNum = (long) (rand.nextInt(900000) + 100000);
		this.id = randNum;
	}
}