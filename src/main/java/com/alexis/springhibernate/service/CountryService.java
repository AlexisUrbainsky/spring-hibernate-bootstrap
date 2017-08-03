package com.alexis.springhibernate.service;

import java.util.List;
import com.alexis.springhibernate.model.Country;

public interface CountryService {
	
	Country findById(int id);
	
	List<Country> getAllCountries(); 
	
}
