package com.eddb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.eddb.business.Class;
import com.eddb.db.ClassRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/classes")
public class ClassController {

	@Autowired
	private ClassRepo classRepo;
	
	@GetMapping("/")
	public Iterable<Class> getAll() {
		return classRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Class> get(@PathVariable Integer id) {
		return classRepo.findById(id);
	}
	
	@PostMapping("/")
	public Class add(@RequestBody Class classs) {
		return classRepo.save(classs);
	}
	
	@PutMapping("/")
	public Class update(@RequestBody Class classs) {
		return classRepo.save(classs);
	}
	
	@DeleteMapping("/{id}")
	public Optional<Class> delete(@PathVariable Integer id) {
		Optional<Class> classs=classRepo.findById(id);
		if (classs.isPresent()) {
			try {
			classRepo.deleteById(id);
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
		return classs;
	}

}
