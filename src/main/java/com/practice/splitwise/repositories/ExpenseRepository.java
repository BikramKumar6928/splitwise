package com.practice.splitwise.repositories;

import com.practice.splitwise.beans.Expense;
import com.practice.splitwise.beans.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, UUID> {
    List<Expense> findByAddedBy(Person person);
}
