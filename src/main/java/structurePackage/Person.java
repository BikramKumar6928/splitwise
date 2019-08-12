package structurePackage;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Entity
public class Person {

	@Id
	private static Long id=0L;
	private String firstName;
	private String middleName;
	private String lastName;
	private List<Expense> expenseList;
	private List<Group> groupList;
	private String userName;
	private String password;



	public Person(String firstName, String middleName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;

		groupList = new ArrayList<>();
		expenseList = new ArrayList<>();

		id++;
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
		if(middleName == "")
			return String.format("%s %s",firstName,lastName);

		return String.format("%s %s %s",firstName,middleName,lastName);
	}



	public void addExpense(Group group, Expense expense){
		if(!checkGroupPresent(group)) {
			Utilities.printError(String.format("Group %s not present in %s", group, this));
			return;
		}
		addToExpenseList(expense);
	}

	private void addToExpenseList(Expense expense) {
		expenseList.add(expense);
	}

	private boolean checkGroupPresent(Group group){
		Stream<Group> groupStream= groupList.stream();
		Group g = groupStream.filter((groupListItem) -> {
			if (groupListItem == group)
				return true;
			return false;
		})
				.findAny()
				.orElse(null);
		return g != null;
	}

	public static Long getId() {
		return id;
	}

	public static void setId(Long id) {
		Person.id = id;
	}

	@Override
	public String toString() {
		return getName();
	}
}
