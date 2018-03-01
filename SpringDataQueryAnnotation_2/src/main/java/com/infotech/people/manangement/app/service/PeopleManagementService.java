package com.infotech.people.manangement.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.people.manangement.app.dao.PeopleManangementDao;
import com.infotech.people.manangement.app.entities.Person;

@Service
public class PeopleManagementService {

	@Autowired
	private PeopleManangementDao peopleManangementDao;

	public List<Person> getPersonsInfoByLastName(String lastName) {
		return peopleManangementDao.getPeronInfoByLastName(lastName);
	}

	public List<Person> getPersonsInfoByFirstNameAndEmail(String firstName, String email) {
		return peopleManangementDao.findByFirstNameAndEmail(firstName, email);
	}

	public List<Person> listPerson() {
		List<Person> personList = (List<Person>) peopleManangementDao.findAll();
		if (personList == null || personList.size() < 3) {
			for (int i = 0; i < 3; i++) {
				Person person = new Person();
				person.setFirstName("Dara" + i);
				person.setLastName("Mean" + i);
				person.setEmail("daramean" + i + "@gmail.com");
				peopleManangementDao.save(person);
			}
			personList = (List<Person>) peopleManangementDao.findAll();
			return personList;
		}
		return personList;
	}
}
