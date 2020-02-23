package com.practice.splitwise.exceptions;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(String message){
        super(message);
    }
}
