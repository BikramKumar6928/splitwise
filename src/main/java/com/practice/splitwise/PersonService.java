package com.practice.splitwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

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

	public Person getPersonById(String stringId){
		Long id = Long.parseLong(stringId);
		return personRepository.findById(id).orElse(null);
	}

	public Long insertPerson(Person person){
		return personRepository.save(person).getId();
	}


	public void updatePerson(String stringId, Person person) {
		person.setId(Long.parseLong(stringId));
		personRepository.save(person);
	}


	public void deletePerson(String stringId) {
		long id = Long.parseLong(stringId);
		personRepository.deleteById(id);
	}
}
