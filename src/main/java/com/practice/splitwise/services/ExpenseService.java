package com.practice.splitwise.services;

import com.practice.splitwise.beans.Expense;
import com.practice.splitwise.beans.Group;
import com.practice.splitwise.beans.Person;
import com.practice.splitwise.exceptions.ExpenseNotFoundException;
import com.practice.splitwise.repositories.ExpenseRepository;
import com.practice.splitwise.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;
    private PersonService personService;
    private GroupService groupService;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, PersonService personService){
        this.expenseRepository = expenseRepository;
        this.personService = personService;
    }

    public Expense getExpenseById(UUID expenseId) {
        return expenseRepository.findById(expenseId).orElseThrow(ExpenseNotFoundException::new);
    }

    public List<Expense> getAllExpenses() {
        return Utilities.IterableToList(expenseRepository.findAll());
    }

    public UUID insertExpense(Expense expense) {
        return expenseRepository.save(expense).getId();
    }

    public Expense updateExpense(UUID id, Expense expense) {
        expense.setId(id);
        return expenseRepository.save(expense);
    }

    public void deleteExpense(UUID id) {
        expenseRepository.deleteById(id);
    }

    public List<Expense> getAllExpensesForPerson(UUID personId) {
        Person person = personService.getPersonById(personId);
        return expenseRepository.findByAddedBy(person);
    }

    public Expense getExpenseByIdForPerson(UUID personId, UUID expenseId) {
        Expense expense = getExpenseById(expenseId);
        if(expense.getAddedBy().getId() != personId)
            throw new ExpenseNotFoundException();
        return expense;
    }

    public UUID insertExpenseForPerson(UUID personId, Expense expense) {
        return insertExpenseForPersonGetObject(personId, expense).getId();
    }

    public Expense updateExpenseForPerson(UUID personId, UUID expenseid, Expense expense) {
        expense.setId(expenseid);
        return insertExpenseForPersonGetObject(personId, expense);
    }

    public void deleteExpenseForPerson(UUID personID, UUID expenseId) {
        Expense expense = getExpenseByIdForPerson(personID, expenseId);
        expenseRepository.delete(expense);
    }

    private Expense insertExpenseForPersonGetObject(UUID personId, Expense expense) {
        Person person = personService.getPersonById(personId);
        expense.setAddedBy(person);
        return expenseRepository.save(expense);
    }

    public UUID insertExpenseForPerson(UUID personId, UUID groupId, Expense expense) {
        Group group = groupService.getGroupById(groupId);
        Expense expenseWithAddedBy = insertExpenseForPersonGetObject(personId, expense);
        group.addExpense(expenseWithAddedBy);
        return expenseWithAddedBy.getId();
    }
}
