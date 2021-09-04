package com.eddb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.eddb.business.Instructor;
import com.eddb.db.InstructorRepo;



@CrossOrigin
@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
	
	@Autowired
	private InstructorRepo instructorRepo;
	
	@GetMapping("/")
	public Iterable<Instructor> getAll() {
		return instructorRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Instructor> get(@PathVariable Integer id) {
		return instructorRepo.findById(id);
	}
	
	@PostMapping("/")
	public Instructor add(@RequestBody Instructor instructor) {
		return instructorRepo.save(instructor);
	}
	
	@PutMapping("/")
	public Instructor update(@RequestBody Instructor instructor) {
		return instructorRepo.save(instructor);
	}
	
	@DeleteMapping("/{id}")
	public Optional<Instructor> delete(@PathVariable Integer id) {
		Optional<Instructor> instructor=instructorRepo.findById(id);
		if (instructor.isPresent()) {
			try {
			instructorRepo.deleteById(id);
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
		return instructor;
	}

}
