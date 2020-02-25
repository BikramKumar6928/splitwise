package com.practice.splitwise.services;

import com.practice.splitwise.beans.Expense;
import com.practice.splitwise.beans.Person;
import com.practice.splitwise.exceptions.PersonNotFoundException;
import com.practice.splitwise.repositories.PersonRepository;
import com.practice.splitwise.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository){
		this.personRepository = personRepository;
	}




	public List<Person> getAllPersons(){
		return Utilities.IterableToList(personRepository.findAll());
	}

	public Person getPersonById(UUID id){
		return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
	}

	public UUID insertPerson(Person person){
		return personRepository.save(person).getId();
	}

	public Person updatePerson(UUID id, Person person) {
		person.setId(id);
		return personRepository.save(person);
	}

	public void deletePerson(UUID id) {
		personRepository.deleteById(id);
	}



}
