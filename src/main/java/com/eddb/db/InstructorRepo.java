package com.eddb.db;

import org.springframework.data.repository.CrudRepository;

import com.eddb.business.Instructor;

public interface InstructorRepo extends CrudRepository<Instructor, Integer> {

}
