package com.practice.splitwise;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import structurePackage.Person;

@RestController
public class PersonController {

	@RequestMapping("/persons")
	public String getPersons(){
		return new Person("Bikram","","Kumar","bikram","bikiram").toString();
	}

	@RequestMapping("/persons/{id}")
	public String specific(@PathVariable("id") String id){
		return new Person(id,"","Kumar","bikram","bikiram").toString();

	}
}
