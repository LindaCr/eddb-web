package com.eddb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.eddb.business.Major;
import com.eddb.db.MajorRepo;



@CrossOrigin
@RestController
@RequestMapping("/api/majors")
public class MajorController {

	@Autowired
	private MajorRepo majorRepo;
	
	@GetMapping("/")
	public Iterable<Major> getAll() {
		return majorRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Major> get(@PathVariable Integer id) {
		return majorRepo.findById(id);
	}
	
	@PostMapping("/")
	public Major add(@RequestBody Major major) {
		return majorRepo.save(major);
	}
	
	@PutMapping("/")
	public Major update(@RequestBody Major major) {
		return majorRepo.save(major);
	}
	
	@DeleteMapping("/{id}")
	public Optional<Major> delete(@PathVariable Integer id) {
		Optional<Major> major=majorRepo.findById(id);
		if (major.isPresent()) {
			try {
			majorRepo.deleteById(id);
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
		return major;
	}
}
