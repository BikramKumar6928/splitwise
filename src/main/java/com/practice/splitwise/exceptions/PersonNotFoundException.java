package com.practice.splitwise.exceptions;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String message){
        super(message);
    }
    public PersonNotFoundException() {
        super("Person does not have an account");
    }
}
