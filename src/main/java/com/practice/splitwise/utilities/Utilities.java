package com.practice.splitwise.utilities;

import com.practice.splitwise.beans.Expense;
import com.practice.splitwise.beans.Person;
import com.practice.splitwise.beans.Group;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
	public static <T> List<T> IterableToList(Iterable<T> iterable){
		List<T> list = new ArrayList<>();
		iterable.forEach(list::add);
		return list;
	}

	public static void printError(String s) {
		System.err.println("[ERROR]: " + s);
	}

}
