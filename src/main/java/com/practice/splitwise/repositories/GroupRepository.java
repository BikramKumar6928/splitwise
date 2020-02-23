package com.practice.splitwise.repositories;

import com.practice.splitwise.beans.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository extends CrudRepository<Group, UUID> {
}
