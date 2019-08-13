package com.practice.splitwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import structurePackage.Person;

import java.util.List;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/persons")
	public List<Person> getPersons(){
		return personService.getAllPersons();
	}

	@RequestMapping("/persons/{id}")
	public Person getPersonById(@PathVariable("id") String id){
		return personService.getPersonById(id);
	}
}
