package com.alexis.springhibernate.service;

import java.util.List;
import com.alexis.springhibernate.model.Travel;

public interface TravelService {

	Travel findById(int id);
	
	void persisteTravel(Travel t);
	
	void updateTravel(Travel t);
	
	void deleteTravel(Travel t);
	
	List<Travel> getAllTravels();
	
}
