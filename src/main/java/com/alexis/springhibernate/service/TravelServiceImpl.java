package com.alexis.springhibernate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alexis.springhibernate.dao.TravelDao;
import com.alexis.springhibernate.model.Travel;

@Service("travelService")
public class TravelServiceImpl implements TravelService {
	
	@Autowired
	private	TravelDao travelDao;
	
	public void setTravelDao(TravelDao travelDao) {
		this.travelDao = travelDao;
	}

	@Override
	public Travel findById(int id) {
		return travelDao.findById(id);
	}

	@Override
	public void persisteTravel(Travel t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTravel(Travel t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTravel(Travel t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Travel> getAllTravels() {
		// TODO Auto-generated method stub
		return null;
	}

}