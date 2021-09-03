package com.eddb.db;

import org.springframework.data.repository.CrudRepository;

import com.eddb.business.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>{

}
