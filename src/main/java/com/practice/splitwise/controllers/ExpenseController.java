package com.practice.splitwise.controllers;

import com.practice.splitwise.beans.Expense;
import com.practice.splitwise.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getExpenses(@RequestHeader UUID personId){
        return expenseService.getAllExpensesForPerson(personId);
    }

    @GetMapping("/{expenseId}")
    public Expense getExpenseById(@RequestHeader UUID personId, @PathVariable UUID expenseId){
        return expenseService.getExpenseByIdForPerson(personId, expenseId);
    }

    @PostMapping
    public UUID insertExpense(@RequestHeader UUID personId, @RequestBody Expense expense){
        return expenseService.insertExpenseForPerson(personId, expense);
    }

    @PutMapping("/{expenseId}")
    public Expense updateExpense(@RequestHeader UUID personId, @PathVariable UUID expenseId, @RequestBody Expense expense){
        return expenseService.updateExpenseForPerson(personId, expenseId, expense);
    }

    @DeleteMapping("/{expenseId}")
    public void deleteExpense(@RequestHeader UUID personId, @PathVariable UUID expenseId){
        expenseService.deleteExpenseForPerson(personId, expenseId);
    }
}
