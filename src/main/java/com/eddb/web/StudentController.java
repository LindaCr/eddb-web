package com.eddb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.eddb.business.Student;
import com.eddb.db.StudentRepo;



@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;
	
	@GetMapping("/")
	public Iterable<Student> getAll() {
		return studentRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Student> get(@PathVariable Integer id) {
		return studentRepo.findById(id);
	}
	
	@PostMapping("/")
	public Student add(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@PutMapping("/")
	public Student update(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@DeleteMapping("/{id}")
	public Optional<Student> delete(@PathVariable Integer id) {
		Optional<Student> student=studentRepo.findById(id);
		if (student.isPresent()) {
			try {
			studentRepo.deleteById(id);
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
		return student;
	}
}
