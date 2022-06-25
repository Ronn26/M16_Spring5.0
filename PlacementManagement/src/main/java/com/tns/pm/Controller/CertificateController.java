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

import com.tns.pm.Service.CertificateService;
import com.tns.pm.entities.Certificate;
import com.tns.pm.entities.College;


@RestController
public class CertificateController {
	
	@Autowired
	private CertificateService service;
	
//	Restful API methods for retrieval
	
	@GetMapping("/certificate")
	public List<Certificate> getAllCertificates() {
		return service.listAll();
	}
	
	@GetMapping("/certificate/{id}")
	public ResponseEntity<Certificate> getCertificateById(@PathVariable Integer id) {
		try {
			Certificate p = service.searchById(id);
			return new ResponseEntity<Certificate>(p, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/college/{clgId}/certificate")
	public void Add(@RequestBody Certificate certificate,@PathVariable Integer clgId) {
		certificate.setCollege(new College(clgId));
		service.add(certificate);
	}
	
	@PutMapping("/certificate/{id}")
	public ResponseEntity<?> update(@RequestBody Certificate certificate, @PathVariable Integer id) {
		try {
			Certificate p = service.searchById(id);
			service.add(certificate);
			return new ResponseEntity<>(p, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/certificate/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
}