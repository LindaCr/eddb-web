package com.eddb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.eddb.business.MajorClass;
import com.eddb.db.MajorClassRepo;



@CrossOrigin
@RestController
@RequestMapping("/api/major-classes")
public class MajorClassController {

	@Autowired
	private MajorClassRepo majorClassRepo;
	
	@GetMapping("/")
	public Iterable<MajorClass> getAll() {
		return majorClassRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<MajorClass> get(@PathVariable Integer id) {
		return majorClassRepo.findById(id);
	}
	
	@PostMapping("/")
	public MajorClass add(@RequestBody MajorClass majorClass) {
		return majorClassRepo.save(majorClass);
	}
	
	@PutMapping("/")
	public MajorClass update(@RequestBody MajorClass majorClass) {
		return majorClassRepo.save(majorClass);
	}
	
	@DeleteMapping("/{id}")
	public Optional<MajorClass> delete(@PathVariable Integer id) {
		Optional<MajorClass> majorClass=majorClassRepo.findById(id);
		if (majorClass.isPresent()) {
			try {
			majorClassRepo.deleteById(id);
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
		return majorClass;
	}
}
