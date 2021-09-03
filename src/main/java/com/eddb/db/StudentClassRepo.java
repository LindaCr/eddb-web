package com.eddb.db;

import org.springframework.data.repository.CrudRepository;

import com.eddb.business.StudentClass;

public interface StudentClassRepo extends CrudRepository<StudentClass, Integer>{

}
