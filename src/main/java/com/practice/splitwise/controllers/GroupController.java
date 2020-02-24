package com.practice.splitwise.controllers;

import com.practice.splitwise.beans.Group;
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
    public void updateGroup(@PathVariable UUID id, @RequestBody Group group){
        groupService.updateGroup(id, group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable UUID id){
        groupService.deleteGroup(id);
    }

    @PostMapping("/{groupId}/person/{personId}")
    public void addPersonToGroup(@PathVariable UUID groupId, @PathVariable UUID personId){
        groupService.addPersonToGroup(groupId,personId);
    }
}
