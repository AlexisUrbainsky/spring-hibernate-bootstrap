package com.alexis.springhibernate.dao;

import org.springframework.stereotype.Repository;

import com.alexis.springhibernate.model.Person;

@Repository("personDao")
public class PersonDaoImpl extends AbstractDao<Integer, Person> implements PersonDao {
	
	@Override
	public Person findById(int id) {
		return getById(id);
	}

	@Override
	public void persistPerson(Person p) {
		persist(p);
	}

	@Override
	public void updatePerson(Person p) {
		update(p);
	}

	@Override
	public void deletePerson(Person p) {
		delete(p);
	}

}
