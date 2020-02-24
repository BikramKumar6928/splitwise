package com.practice.splitwise.services;

import com.practice.splitwise.beans.Person;
import com.practice.splitwise.exceptions.PersonNotFoundException;
import com.practice.splitwise.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


//	private List<Person> personList = new ArrayList<>(Arrays.asList(
//			new Person("Bikram","","Kumar","bikram","qwerty"),
//			new Person("Hibiki","","Sakura","hibiki","qwerty"),
//			new Person("Machio","","San","machio","qwerty"),
//			new Person("Souryuin","","San","souryuin","qwerty")
//
//	));

	public List<Person> getAllPersons(){
		List<Person> personList = new ArrayList<>();
		personRepository.findAll().forEach(personList::add);
		return personList;

	}

	public Person getPersonById(UUID id){
		return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
	}

	public UUID insertPerson(Person person){
		return personRepository.save(person).getId();
	}


	public Person updatePerson(String stringId, Person person) {
		person.setId(UUID.fromString(stringId));
		return personRepository.save(person);
	}


	public void deletePerson(String stringId) {
		UUID id = UUID.fromString(stringId);
		personRepository.deleteById(id);
	}
}
