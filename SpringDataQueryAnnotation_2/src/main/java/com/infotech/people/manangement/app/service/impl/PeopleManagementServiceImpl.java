package com.infotech.people.manangement.app.service.impl;

import com.infotech.people.manangement.app.dao.PeopleManangementDao;
import com.infotech.people.manangement.app.entities.Person;
import com.infotech.people.manangement.app.service.PeopleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Create By: Ron Rith
Create Date: 3/1/2018
*/
@Service
public class PeopleManagementServiceImpl implements PeopleManagementService {
    @Autowired
    private PeopleManangementDao peopleManangementDao;

    public List<Person> getPersonsInfoByLastName(String lastName) {
        return peopleManangementDao.getByLastNameContaining(lastName);
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
