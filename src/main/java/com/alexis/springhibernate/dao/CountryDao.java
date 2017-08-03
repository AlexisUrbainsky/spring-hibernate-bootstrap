package com.alexis.springhibernate.dao;

import java.util.List;
import com.alexis.springhibernate.model.Country;

public interface CountryDao {

	Country findById(int id);

	List<Country> getAllCountries();
	
}
