package com.practice.splitwise.services;

import com.practice.splitwise.beans.Expense;
import com.practice.splitwise.beans.Person;
import com.practice.splitwise.beans.Group;
import com.practice.splitwise.exceptions.GroupNotFoundException;
import com.practice.splitwise.repositories.GroupRepository;
import com.practice.splitwise.repositories.PersonRepository;
import com.practice.splitwise.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GroupService {

    private GroupRepository groupRepository;
    private PersonService personService;
    private ExpenseService expenseService;


    @Autowired
    public GroupService(GroupRepository groupRepository, ExpenseService expenseService, PersonService personService){
        this.groupRepository = groupRepository;
        this.personService = personService;
        this.expenseService = expenseService;
    }

    public List<Group> getAllGroups() {
        return Utilities.IterableToList(groupRepository.findAll());
    }

    public UUID createGroup(Group group) {
        return groupRepository.save(group).getId();

    }

    public Group getGroupById(UUID id) {
        return groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }

    public Group updateGroup(UUID id, Group group) {
        group.setId(id);
        return groupRepository.save(group);
    }

    public void deleteGroup(UUID id) {
        groupRepository.deleteById(id);
    }

    public Group addPersonToGroup(UUID groupId, UUID personId) {
        Person person = personService.getPersonById(personId);
        Group group = getGroupById(groupId);
        group.addMembers(person);
        return groupRepository.save(group);
    }

    public Group removePersonFromGroup(UUID groupId, UUID personId){
        Person person = personService.getPersonById(personId);
        Group group = getGroupById(groupId);
        group.removeMembers(person);
        return groupRepository.save(group);
    }

    public UUID addExpense(UUID groupId, Expense expense){
        Group group = getGroupById(groupId);
        group.addExpense(expense);
        Group savedGroup = groupRepository.save(group);
        return expense.getId();
    }

    public List<Expense> getExpenseList(UUID groupId){
        Group group = getGroupById(groupId);
        return group.getExpenseList();
    }

    public Group addExpenseToGroup(UUID groupId, UUID expenseId) {
        Expense expense = expenseService.getExpenseById(expenseId);
        Group group = getGroupById(groupId);
        group.addExpense(expense);
        return groupRepository.save(group);
    }

    public Group removeExpenseFromGroup(UUID groupId, UUID expenseId) {
        Expense expense = expenseService.getExpenseById(expenseId);
        Group group = getGroupById(groupId);
        group.removeExpense(expense);
        return groupRepository.save(group);
    }
}
