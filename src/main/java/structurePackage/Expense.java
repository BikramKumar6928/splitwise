package structurePackage;

import java.util.Date;
import java.util.Map;

public class Expense {
	private Date date;
	private double amount;
	private Group group;
	private Map<Person,Double> spenderList;
	private Map<Person,Double> recieverList;
}
