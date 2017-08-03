package com.alexis.springhibernate.dao;

import com.alexis.springhibernate.model.Travel;

public class TravelDaoImpl extends AbstractDao<Integer, Travel> implements TravelDao {

	@Override
	public Travel findById(int id) {
		return getById(id);
	}

	@Override
	public void persistTravel(Travel t) {
		persist(t);
	}

	@Override
	public void updateTravel(Travel t) {
		update(t);
	}

	@Override
	public void deleteTravel(Travel t) {
		delete(t);
	}

}
