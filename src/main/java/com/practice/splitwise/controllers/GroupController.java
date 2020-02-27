package com.practice.splitwise.controllers;

import com.practice.splitwise.beans.Expense;
import com.practice.splitwise.beans.Group;
import com.practice.splitwise.beans.Person;
import com.practice.splitwise.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getGroups(){
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable("id") UUID id){
        return groupService.getGroupById(id);
    }

    @PostMapping
    public UUID createGroup(@RequestBody Group person){
        return groupService.createGroup(person);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable UUID id, @RequestBody Group group){
        return groupService.updateGroup(id, group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable UUID id){
        groupService.deleteGroup(id);
    }

    @PostMapping("/{groupId}/persons/{personId}/add")
    public Group addPersonToGroup(@PathVariable UUID groupId, @PathVariable UUID personId){
        return groupService.addPersonToGroup(groupId,personId);
    }

    @PostMapping("/{groupId}/persons/{personId}/remove")
    public Group removePersonFromGroup(@PathVariable UUID groupId, @PathVariable UUID personId){
        return groupService.removePersonFromGroup(groupId,personId);
    }

    @PostMapping("/{groupId}/expenses/{expenseId}/add")
    public Group addExpenseToGroup(@PathVariable UUID groupId, @PathVariable UUID expenseId){
        return groupService.addExpenseToGroup(groupId, expenseId);
    }

    @PostMapping("/{groupId}/expenses/{expenseId}/remove")
    public Group removeExpenseFromGroup(@PathVariable UUID groupId, @PathVariable UUID expenseId){
        return groupService.removeExpenseFromGroup(groupId, expenseId);
    }
}
