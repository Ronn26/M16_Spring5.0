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

import com.tns.pm.Service.PlacementService;
import com.tns.pm.entities.Placement;

@RestController
public class PlacementController {
	
	@Autowired
	private PlacementService service;
	
//	Restful API methods for retrieval
	
	@GetMapping("/college/{collegeId}/placement")
	public List<Placement> getAllPlacements(@PathVariable Integer collegeId) {
		return service.listAll(collegeId);
	}
	
	@GetMapping("/placement/{id}")
	public ResponseEntity<Placement> getPlacementById(@PathVariable Integer id) {
		try {
			Placement p = service.searchById(id);
			return new ResponseEntity<Placement>(p, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/placement")
	public void Add(@RequestBody Placement placement) {
		service.add(placement);
	}
	
	@PutMapping("/placement/{id}")
	public ResponseEntity<?> update(@RequestBody Placement placement, @PathVariable Integer id) {
		try {
			Placement p = service.searchById(id);
			service.add(placement);
			return new ResponseEntity<>(p, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/placement/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
}
