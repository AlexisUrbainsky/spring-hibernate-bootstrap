package com.alexis.springhibernate.dao;

import com.alexis.springhibernate.model.Passport;

public interface PassportDao {
	
	Passport findById(int id);
	
	void persistPassport(Passport p);
	
	void updatePassport(Passport p);
	
	void deletePassport(Passport p);
	
}
