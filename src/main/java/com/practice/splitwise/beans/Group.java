package com.practice.splitwise.beans;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="GroupTable")
public class Group {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private UUID id;

	private String name;
	@OneToMany
	private List<Expense> expenseList;
	@OneToMany
	private List<Person> personList;


	public void setName(String name) {

	}

	public String getName() {
		return null;
	}

	public Long addExpense(Expense expense) {
		return 0L;
	}

	public List<Expense> getExpenseList() {
		return null;
	}

	public void mergeGroup(Group group) {

	}

	public List<Person> getMembers() {
		return null;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void removeMembers(Person person) {

	}

	public void addMembers(Person person) {

	}
}
