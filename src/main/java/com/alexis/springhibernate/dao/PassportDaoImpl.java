package com.alexis.springhibernate.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.alexis.springhibernate.model.Passport;

@Transactional
@Repository("passportDao")
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
