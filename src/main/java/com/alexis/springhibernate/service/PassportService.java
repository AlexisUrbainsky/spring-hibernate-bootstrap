package com.alexis.springhibernate.service;

import java.util.List;

import com.alexis.springhibernate.model.Passport;


public interface PassportService {
	
	Passport findById(int id);
	
	void persistePassport(Passport p);
	
	void updatePassport(Passport p);
	
	void deletePassport(Passport p);
	
	List<Passport> getAllPassports();
	
}
