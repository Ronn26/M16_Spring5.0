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

import com.tns.pm.Service.UserService;
import com.tns.pm.entities.User;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/user")
	public List<User> list() {
		return service.listAll();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id) {
		try {
			User user = service.searchById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/user")
	public void add(@RequestBody User user) {
		service.add(user);
	}

	// RESTful API method for Update operation
	@PutMapping("/user/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
		try {
			User u = service.searchById(id);
			service.add(user);
			return new ResponseEntity<>(u,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
