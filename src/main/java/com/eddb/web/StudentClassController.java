package com.eddb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.eddb.business.StudentClass;
import com.eddb.db.StudentClassRepo;



@CrossOrigin
@RestController
@RequestMapping("/api/student-classes")
public class StudentClassController {

	@Autowired
	private StudentClassRepo studentClassRepo;
	
	@GetMapping("/")
	public Iterable<StudentClass> getAll() {
		return studentClassRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<StudentClass> get(@PathVariable Integer id) {
		return studentClassRepo.findById(id);
	}
	
	@PostMapping("/")
	public StudentClass add(@RequestBody StudentClass studentClass) {
		return studentClassRepo.save(studentClass);
	}
	
	@PutMapping("/")
	public StudentClass update(@RequestBody StudentClass studentClass) {
		return studentClassRepo.save(studentClass);
	}
	
	@DeleteMapping("/{id}")
	public Optional<StudentClass> delete(@PathVariable Integer id) {
		Optional<StudentClass> studentClass=studentClassRepo.findById(id);
		if (studentClass.isPresent()) {
			try {
			studentClassRepo.deleteById(id);
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
		return studentClass;
	}
}
