package com.practice.splitwise.beans;

import com.practice.splitwise.beans.enums.Category;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
public class Expense implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private UUID id;

	private Date date;
	private Category category;
	private boolean isUpdated = false;
	private Amount amount;

	@OneToOne(targetEntity = Person.class)
	private Person addedBy;

	@OneToMany(targetEntity=Expense.class)
	private List<Expense> subExpenseList;

	@OneToMany(targetEntity=Receipt.class)
	private List<Receipt> receiptList;

	@OneToMany(targetEntity=Spender.class)
	private List<Spender> spenderList;

	@OneToMany(targetEntity=Spender.class)
	private List<Spender> beneficiaryList;

	public  Expense (Date date, Person addedBy, Category category, Expense... subExpenseList){
		this(date,addedBy,category, Arrays.asList(subExpenseList));
	}

	public  Expense (Person addedBy, Category category, Expense... subExpenseList){
		this(new Date(),addedBy,category, Arrays.asList(subExpenseList));
	}

	public Expense(){}

	public Expense (Date date, Person addedBy, Category category, List<Expense> subExpenseList){
		this.date = date;
		this.addedBy = addedBy;
		this.category = category;
		this.subExpenseList = subExpenseList;
		updateMembers();
	}

	private void updateMembers() {
		if(isUpdated){
			return;
		}
		isUpdated = true;
		for (Expense expense : subExpenseList) {
			amount.add(expense.getAmount());
			spenderList.addAll(expense.getSpenderList());
			beneficiaryList.addAll(expense.getBeneficiaryList());
		}
		spenderList = removeDuplicates(spenderList);
		removeDuplicates(beneficiaryList);
	}

	private <T> List<T> removeDuplicates(List<T> list) {
		return list.stream().distinct().collect(Collectors.toList());
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public List<Spender> getSpenderList() {
		return spenderList;
	}

	public void setSpenderList(List<Spender> spenderList) {
		this.spenderList = spenderList;
	}

	public List<Spender> getBeneficiaryList() {
		return beneficiaryList;
	}

	public void setBeneficiaryList(List<Spender> beneficiaryList) {
		this.beneficiaryList = beneficiaryList;
	}

	public List<Expense> getSubExpenseList() {
		return subExpenseList;
	}

	public void setSubExpenseList(List<Expense> subExpenseList) {
		this.subExpenseList = subExpenseList;
	}

	public Person getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Person addedBy) {
		this.addedBy = addedBy;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Receipt> getReceiptList() {
		return receiptList;
	}

	public void setReceiptList(List<Receipt> receiptList) {
		this.receiptList = receiptList;
	}

	public void addReceipt(Receipt receipt){
		receiptList.add(receipt);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
