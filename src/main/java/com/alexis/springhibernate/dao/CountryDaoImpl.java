package com.alexis.springhibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import com.alexis.springhibernate.model.Country;
import com.alexis.springhibernate.model.Person;

@Transactional
@Repository("countryDao")

public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao {

	@Override
	public Country findById(int id) {
		return getById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getAllCountries() {
		Criteria criteria = createEntityCriteria();
	    return (List<Country>) criteria.list();
	}

}
