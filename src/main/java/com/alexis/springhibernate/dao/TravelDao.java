package com.alexis.springhibernate.dao;

import com.alexis.springhibernate.model.Travel;

public interface TravelDao {

	Travel findById(int id);
	
	void persistTravel(Travel t);
	
	void updateTravel(Travel t);
	
	void deleteTravel(Travel t);
	
}
