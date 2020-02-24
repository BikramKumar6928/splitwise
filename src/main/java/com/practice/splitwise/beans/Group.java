package com.practice.splitwise.beans;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addExpense(Expense expense) {
		expenseList.add(expense);
	}

	public List<Expense> getExpenseList() {
		return expenseList;
	}

	public void mergeGroup(Group group) {
		expenseList.addAll(group.getExpenseList());
		personList.addAll(group.getMembers());
	}

	public List<Person> getMembers() {
		return personList;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void removeMembers(Person person) {
		personList = personList.parallelStream()
				.filter(personOfList-> personOfList.getId() != person.getId())
				.collect(Collectors.toList());
	}

	public void addMembers(Person person) {
		personList.add(person);
	}
}
