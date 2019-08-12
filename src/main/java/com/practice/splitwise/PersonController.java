package com.practice.splitwise;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@RequestMapping("/persons")
	public String getPersons(){
		return "Hello";
	}

	@RequestMapping("/persons/{id}")
	public String specific(@PathVariable("id") String id){
		return id;
	}
}
