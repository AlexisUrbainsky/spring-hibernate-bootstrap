package com.alexis.springhibernate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alexis.springhibernate.dao.PassportDao;
import com.alexis.springhibernate.model.Passport;

@Service("passportService")
public class PassportServiceImpl implements PassportService {

	@Autowired
	private	PassportDao passportDao;
	
	public void setPassportDao(PassportDao passportDao) {
		this.passportDao = passportDao;
	}

	@Override
	public Passport findById(int id) {
		return passportDao.findById(id);
	}

	@Override
	public void persistePassport(Passport p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassport(Passport p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePassport(Passport p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Passport> getAllPassports() {
		// TODO Auto-generated method stub
		return null;
	}

}
