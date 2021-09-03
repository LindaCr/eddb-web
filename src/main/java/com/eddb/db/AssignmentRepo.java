package com.eddb.db;

import org.springframework.data.repository.CrudRepository;

import com.eddb.business.Assignment;

public interface AssignmentRepo extends CrudRepository<Assignment, Integer>{

}
