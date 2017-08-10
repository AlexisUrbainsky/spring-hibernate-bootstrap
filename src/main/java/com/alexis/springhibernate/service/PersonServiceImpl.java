package com.alexis.springhibernate.service;

import java.util.Calendar;
import java.util.Date;
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
		
		Date expirationDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(expirationDate);
		cal.add(Calendar.YEAR,7);
		expirationDate = cal.getTime();

		p.getPassport().setExpirationDate(expirationDate);
		p.getPassport().setPerson(p);

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
