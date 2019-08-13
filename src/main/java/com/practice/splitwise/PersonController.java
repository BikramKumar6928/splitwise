package com.practice.splitwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
