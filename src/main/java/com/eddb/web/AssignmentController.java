package com.eddb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.eddb.business.Assignment;
import com.eddb.db.AssignmentRepo;


@CrossOrigin
@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
	
	@Autowired
	private AssignmentRepo assignmentRepo;
	
	@GetMapping("/")
	public Iterable<Assignment> getAll() {
		return assignmentRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Assignment> get(@PathVariable Integer id) {
		return assignmentRepo.findById(id);
	}
	
	@PostMapping("/")
	public Assignment add(@RequestBody Assignment assignment) {
		return assignmentRepo.save(assignment);
	}
	
	@PutMapping("/")
	public Assignment update(@RequestBody Assignment assignment) {
		return assignmentRepo.save(assignment);
	}
	
	@DeleteMapping("/{id}")
	public Optional<Assignment> delete(@PathVariable Integer id) {
		Optional<Assignment> assignment=assignmentRepo.findById(id);
		if (assignment.isPresent()) {
			try {
			assignmentRepo.deleteById(id);
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
		return assignment;
	}

}
