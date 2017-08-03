package com.alexis.springhibernate.dao;

import com.alexis.springhibernate.model.Person;

public interface PersonDao {

	Person findById(int id);
	
	void persistPerson(Person p);

	void updatePerson(Person p);
	
	void deletePerson(Person p);
	
}
