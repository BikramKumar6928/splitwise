package com.practice.splitwise.structurePackage;

public interface Group {


	void addExpense(Expense expense);
	void setGroupName(String name);
	void mergeGroup(Group group);

}
