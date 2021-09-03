package com.eddb.db;

import org.springframework.data.repository.CrudRepository;

import com.eddb.business.ClassGrade;

public interface ClassGradeRepo extends CrudRepository<ClassGrade, Integer> {

}
