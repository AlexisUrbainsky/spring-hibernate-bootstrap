package com.alexis.springhibernate.dao;

import com.alexis.springhibernate.model.Passport;

public class PassportDaoImpl extends AbstractDao<Integer, Passport> implements PassportDao {

	@Override
	public Passport findById(int id) {
		return getById(id);
	}
	
	@Override
	public void persistPassport(Passport p) {
		persist(p);
	}
	
	@Override
	public void updatePassport(Passport p) {
		update(p);
	}
	
	@Override
	public void deletePassport(Passport p) {
		delete(p);
	}

}
