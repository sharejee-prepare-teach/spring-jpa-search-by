package com.infotech.people.manangement.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.people.manangement.app.dao.PeopleManangementDao;
import com.infotech.people.manangement.app.entities.Person;

public interface PeopleManagementService {

	List<Person> getPersonsInfoByLastName(String lastName);

	List<Person> getPersonsInfoByFirstNameAndEmail(String firstName, String email);

	List<Person> listPerson();
}
