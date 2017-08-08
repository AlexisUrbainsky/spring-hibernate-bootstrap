package com.alexis.springhibernate.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.alexis.springhibernate.model.Country;

@Transactional
@Repository("countryDao")

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
