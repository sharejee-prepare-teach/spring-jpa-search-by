package com.infotech.people.manangement.app.controllers;

import com.infotech.people.manangement.app.entities.Person;
import com.infotech.people.manangement.app.service.PeopleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
Create By: Ron Rith
Create Date: 3/1/2018
*/
@RestController
@RequestMapping(value = "/api/people")
public class PersonRestController {
    @Autowired
    private PeopleManagementService peopleManagementService;

    @RequestMapping(method = RequestMethod.GET)
    private List<Person> getAllPerson() {
        return (List<Person>) peopleManagementService.listPerson();
    }

    @RequestMapping(value = "/{lastname}", method = RequestMethod.GET)
    private List<Person> getPersonsInfoByLastName(@PathVariable("lastname") String lastname) {
        List<Person> personList = new ArrayList<>();
        if (lastname != null) {
            personList = (List<Person>) peopleManagementService.getPersonsInfoByLastName(lastname);
        }
        return personList;
    }
}
