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
    public List<Expense> getExpenses(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable("id") UUID id){
        return expenseService.getExpenseById(id);
    }

    @PostMapping
    public UUID insertExpense(@RequestBody Expense expense){
        return expenseService.insertExpense(expense);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable UUID id, @RequestBody Expense expense){
        return expenseService.updateExpense(id,expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable UUID id){
        expenseService.deleteExpense(id);
    }
}
