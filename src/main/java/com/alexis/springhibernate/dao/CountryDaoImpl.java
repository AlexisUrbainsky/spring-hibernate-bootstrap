package com.alexis.springhibernate.dao;

import java.util.List;

import com.alexis.springhibernate.model.Country;

public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao {

	@Override
	public Country findById(int id) {
		return getById(id);
	}

	@Override
	public List<Country> getAllCountries() {
		return null;
	}

}
