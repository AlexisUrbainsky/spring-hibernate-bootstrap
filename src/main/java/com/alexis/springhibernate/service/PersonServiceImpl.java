package com.alexis.springhibernate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alexis.springhibernate.dao.PersonDao;
import com.alexis.springhibernate.model.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public Person findById(int id) {
		return personDao.findById(id);
	}

	@Override
	public void persistePerson(Person p) {
		personDao.persistPerson(p); 

	}

	@Override
	public void updatePerson(Person p) {
		personDao.updatePerson(p);
	}

	@Override
	public void deletePerson(Person p) {
		personDao.deletePerson(p);
	}

	@Override
	public List<Person> getAllPersons() {
		return personDao.findAllPersons();
	}

}
