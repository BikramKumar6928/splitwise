package com.practice.splitwise.services;

import com.practice.splitwise.beans.Expense;
import com.practice.splitwise.beans.Person;
import com.practice.splitwise.beans.Group;
import com.practice.splitwise.repositories.GroupRepository;
import com.practice.splitwise.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GroupService {

    private GroupRepository groupRepository;
    private PersonRepository personRepository;
    private PersonService personService;

    @Autowired
    public GroupService(GroupRepository groupRepository, PersonRepository personRepository, PersonService personService){
        this.groupRepository = groupRepository;
        this.personRepository = personRepository;
        this.personService = personService;
    }

    public List<Group> getAllGroups() {
        List<Group> groupList = new ArrayList<>();
        groupRepository.findAll().forEach(groupList::add);
        return groupList;
    }

    public UUID createGroup(Group group) {
        return groupRepository.save(group).getId();

    }

    public Group getGroupById(UUID id) {
        return groupRepository.findById(id).orElse(null);
    }

    public void updateGroup(UUID id, Group group) {
        group.setId(id);
        groupRepository.save(group);
    }

    public void deleteGroup(UUID id) {
        groupRepository.deleteById(id);
    }

    public void addPersonToGroup(UUID groupId, UUID personId) {
        Person person = personService.getPersonById(personId);
        Group group = getGroupById(groupId);
        group.addMembers(person);
        groupRepository.save(group);
    }

    public void removePersonFromGroup(UUID groupId, UUID personId){
        Person person = personService.getPersonById(personId);
        Group group = getGroupById(groupId);
        group.removeMembers(person);
        groupRepository.save(group);
    }

    public Long addExpense(UUID groupId, Expense expense){
        Group group = getGroupById(groupId);
        Long expenseId = group.addExpense(expense);
        Group savedGroup = groupRepository.save(group);
        return expenseId;
    }

    public List<Expense> getExpenseList(UUID groupId){
        Group group = getGroupById(groupId);
        return group.getExpenseList();
    }



    


}
