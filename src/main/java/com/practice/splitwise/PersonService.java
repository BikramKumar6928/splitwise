package com.practice.splitwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import structurePackage.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public Long insertPerson(Person person){
//		personRepository.save(person);
		personList.add(person);
		return person.getId();
	}


	public void updatePerson(String stringId, Person person) {
		Long id = Long.parseLong(stringId);
		for(int i=0;i<personList.size();i++){
			if(personList.get(i).getId() == id){
				personList.set(i,person);
				break;
			}
		}
	}


	public void deletePerson(String stringId) {
		Long id = Long.parseLong(stringId);
		personList = personList.stream().filter(item ->{
			return item.getId() != id;
		}).collect(Collectors.toList());
	}
}
