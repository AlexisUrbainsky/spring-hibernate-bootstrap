package com.alexis.springhibernate.service;

import java.util.List;

import com.alexis.springhibernate.model.Person;

public interface PersonService {

	Person findById(int id);
	
	void persistePerson(Person p);
	
	void updatePerson(Person p);
	
	void deletePerson(Person p);
	
	List<Person> getAllPersons();
	
}
