package com.alexis.springhibernate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alexis.springhibernate.dao.CountryDao;
import com.alexis.springhibernate.model.Country;

@Service("countryService")
public class CountryServiceImpl implements CountryService {

	@Autowired
	private	CountryDao countryDao;
	
	public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	@Override
	public Country findById(int id) {
		return countryDao.findById(id);
	}

	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return null;
	}

}
