package com.practice.splitwise;

import com.practice.splitwise.structurePackage.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {

}