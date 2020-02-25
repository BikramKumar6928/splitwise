package com.practice.splitwise.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Currency;
import java.util.UUID;

public class Amount implements Serializable {
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