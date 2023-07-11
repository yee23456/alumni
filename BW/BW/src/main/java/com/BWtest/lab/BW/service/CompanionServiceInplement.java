package com.BWtest.lab.BW.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BWtest.lab.BW.entity.Companion;
import com.BWtest.lab.BW.repository.CompanionRepository;
@Service
public class CompanionServiceInplement implements CompanionService{
	@Autowired
	CompanionRepository repository;
	@Override
	public void AddCompanion(Companion been) {
		repository.save(been);
	}

	@Override
	public void DeleteCompanion(Long CompanionId) {
		repository.deleteById(CompanionId);
		
	}

}
