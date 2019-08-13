package com.practice.splitwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import structurePackage.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {

	private List<Person> personList = new ArrayList<>(Arrays.asList(
			new Person("Bikram","","Kumar","bikram","qwerty"),
			new Person("Hibiki","","Sakura","hibiki","qwerty"),
			new Person("Machio","","San","machio","qwerty"),
			new Person("Souryuin","","San","souryuin","qwerty")

	));

	public List<Person> getAllPersons(){
		return personList;
	}

	public Person getPersonById(String stringId){
		Long id =  Long.parseLong(stringId);
		return personList.stream().filter(item ->{
			return (item.getId() == id);
		}).findFirst().orElse(null);
	}

	public void insertPerson(Person person){
//		personRepository.save(person);

		personList.add(person);
	}




}
