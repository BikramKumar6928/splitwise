package com.practice.splitwise.exceptions;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException(String message){
        super(message);
    }

    public ExpenseNotFoundException(){
        super("Expense not found.");
    }
}
