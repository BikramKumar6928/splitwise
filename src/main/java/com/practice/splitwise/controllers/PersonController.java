package com.practice.splitwise.controllers;

import com.practice.splitwise.services.PersonService;
import com.practice.splitwise.beans.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/persons")
	public List<Person> getPersons(){
		return personService.getAllPersons();
	}

	@RequestMapping("/persons/{id}")
	public Person getPersonById(@PathVariable("id") UUID id){
		return personService.getPersonById(id);
	}

	@RequestMapping(method = RequestMethod.POST,value = "/persons")
	public Long insertPerson(@RequestBody Person person){
		return personService.insertPerson(person);
	}

	@RequestMapping(method = RequestMethod.PUT,value = "/persons/{id}")
	public void updatePerson(@PathVariable String id, @RequestBody Person person){
		personService.updatePerson(id,person);
	}

	@RequestMapping(method = RequestMethod.DELETE,value = "/persons/{id}")
	public void deletePerson(@PathVariable String id){
		personService.deletePerson(id);
	}

}
