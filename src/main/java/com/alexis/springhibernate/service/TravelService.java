package com.alexis.springhibernate.service;

import com.alexis.springhibernate.model.Travel;

public interface TravelService {

	Travel findById(int id);
	
	void persisteTravel(Travel t);
	
	void updateTravel(Travel t);
	
	void deleteTravel(Travel t);
	
}
