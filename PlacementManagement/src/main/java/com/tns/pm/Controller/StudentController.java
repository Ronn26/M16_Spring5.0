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

import com.tns.pm.Service.StudentService;
import com.tns.pm.entities.Student;

@RestController
	public class StudentController {
		;
		@Autowired
		private StudentService service;
		
		// RESTful API methods for Retrieval operations
		@GetMapping("/student")
		public List<Student> getAllStudents() {
			return service.listAll();
		}
		
		
		@GetMapping("/student/{id}")
		public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
			try {
				Student p = service.searchById(id);
				return new ResponseEntity<Student>(p, HttpStatus.OK);
			}
			catch(NoSuchElementException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		// RESTful API method for Create operation
		@PostMapping("/student")
		public void Add(@RequestBody Student student) {
			service.add(student);
		}
		
		
		// RESTful API method for Update operation
		@PutMapping("/student/{id}")
		public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer id) {
			try {
				Student p = service.searchById(id);
				service.add(student);
				return new ResponseEntity<>(p, HttpStatus.OK);
			}
			catch(NoSuchElementException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}	
		}
		
	
		// RESTful API method for Delete operation
		@DeleteMapping("/student/{id}")
		public void delete(@PathVariable Integer id) {
			service.delete(id);
		}
		

	}



