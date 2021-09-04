package com.eddb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.eddb.business.ClassGrade;
import com.eddb.db.ClassGradeRepo;



@CrossOrigin
@RestController
@RequestMapping("/api/class-grades")
public class ClassGradeController {

	@Autowired
	private ClassGradeRepo classGradeRepo;
	
	@GetMapping("/")
	public Iterable<ClassGrade> getAll() {
		return classGradeRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<ClassGrade> get(@PathVariable Integer id) {
		return classGradeRepo.findById(id);
	}
	
	@PostMapping("/")
	public ClassGrade add(@RequestBody ClassGrade classGrade) {
		return classGradeRepo.save(classGrade);
	}
	
	@PutMapping("/")
	public ClassGrade update(@RequestBody ClassGrade classGrade) {
		return classGradeRepo.save(classGrade);
	}
	
	@DeleteMapping("/{id}")
	public Optional<ClassGrade> delete(@PathVariable Integer id) {
		Optional<ClassGrade> classGrade=classGradeRepo.findById(id);
		if (classGrade.isPresent()) {
			try {
			classGradeRepo.deleteById(id);
			}
			catch (DataIntegrityViolationException dive) {
				//catch dive when movie exists as fk on another table
				System.err.println(dive.getRootCause().getMessage());
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Foreign Key Constraint Issue- user id: "+id+"is referred to elsewhere.");
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Exception caught during user delete");
			}
		}
		else {
			System.err.println("User delete error- no user found for id"+id);
		}
		return classGrade;
	}
}
