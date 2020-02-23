package com.practice.splitwise.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Currency;
import java.util.UUID;

@Entity
public class Amount implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private UUID id;
	private double amount;
	private Currency currency;


	public synchronized void add(double amount) {
		this.amount += amount;
	}

	public synchronized void add(Amount amount) {
		this.amount += amount.amount;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}