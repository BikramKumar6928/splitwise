package structurePackage;

import com.practice.splitwise.Person;

import java.util.List;

public interface Group {


	void addExpense(Expense expense);
	void setGroupName(String name);
	void mergeGroup(Group group);

}
