package com.practice.splitwise.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private UUID id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String userName;
	private String password;



	public Person(String firstName, String middleName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public Person() {
	}

	public void setName(String firstName, String lastName){
		 setName(firstName,"",lastName);
	}

	public void setName(String firstName, String middleName, String lastName){
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getName(){
		if("".equals(middleName))
			return String.format("%s %s",firstName,lastName);

		return String.format("%s %s %s",firstName,middleName,lastName);
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
