package structurePackage;

import com.practice.splitwise.Person;

import java.util.Calendar;
import java.util.List;

public class Expense {
	private Calendar date;
	private Amount amount;
	private List<Spender> spenderList;
	private List<Spender> beneficiaryList;
	private List<SubExpense> subExpenseList;
	private Person addedBy;
	private Category category;
	private List<Receipt> receiptList;



}
