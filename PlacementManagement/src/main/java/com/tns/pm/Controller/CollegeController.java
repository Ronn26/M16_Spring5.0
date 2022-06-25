package com.tns.pm.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.pm.Service.CollegeService;
import com.tns.pm.entities.College;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService service;
	
//	Restful API methods for retrieval
	
	@GetMapping("/college")
	public List<College> getAllColleges() {
		return service.listAll();
	}
	
	@GetMapping("/college/{id}")
	public ResponseEntity<College> getCollegeById(@PathVariable Integer id) {
		try {
			College p = service.searchById(id);
			return new ResponseEntity<College>(p, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/college")
	public void Add(@RequestBody College college) {
		service.add(college);
	}
	
	@PutMapping("/college/{id}")
	public ResponseEntity<?> update(@RequestBody College college, @PathVariable Integer id) {
		try {
			College p = service.searchById(id);
			college.setId(id);
			service.add(college);
			return new ResponseEntity<>(p, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/college/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}

