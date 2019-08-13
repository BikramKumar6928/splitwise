package structurePackage;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Person {

	private static Long counter=0L;
	private Long id;
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
		this.id = counter;

		groupList = new ArrayList<>();
		expenseList = new ArrayList<>();

		counter++;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
