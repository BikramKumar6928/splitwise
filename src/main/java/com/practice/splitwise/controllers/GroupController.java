package com.practice.splitwise.controllers;

import com.practice.splitwise.beans.Group;
import com.practice.splitwise.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping("/groups")
    public List<Group> getGroups(){
        return groupService.getAllGroups();
    }

    @RequestMapping("/groups/{id}")
    public Group getGroupById(@PathVariable("id") UUID id){
        return groupService.getGroupById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/groups")
    public UUID createGroup(@RequestBody Group person){
        return groupService.createGroup(person);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/groups/{id}")
    public void updateGroup(@PathVariable UUID id, @RequestBody Group group){
        groupService.updateGroup(id, group);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/groups/{id}")
    public void deleteGroup(@PathVariable UUID id){
        groupService.deleteGroup(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/groups/{groupId}/person/{personId}")
    public void addPersonToGroup(@PathVariable UUID groupId, @PathVariable UUID personId){
        groupService.addPersonToGroup(groupId,personId);
    }
}
