package com.practice.splitwise.beans;

import java.io.Serializable;
import java.util.List;

public class SubExpense implements Serializable {
	private Amount amount;
	private List<Spender> spenderList;
	private List<Spender> beneficiaryList;
	private Receipt receipt;


	public double getAmountValue() {
		return amount.getAmount();
	}





	public List<Spender> getSpenderList() {
		return spenderList;
	}

	public List<Spender> getBeneficiaryList() {
		return beneficiaryList;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public Amount getAmount() {
		return amount;
	}

	public List<Spender> getSpender() {
		return spenderList;
	}
}
