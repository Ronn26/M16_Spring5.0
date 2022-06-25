package com.tns.pm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tns.pm.Repository.StudentRepository;
import com.tns.pm.entities.Student;

    @Service
	@Transactional

	public class StudentService {
		
		 @Autowired
		 private StudentRepository  repo;
		 
		//// Restful Search All Operation Search All Operation
		 public List<Student> listAll() {
		    	return repo.findAll();	
		    }
		    
		
	    // Restful Search Operation
	    public Student searchById(Integer id) {
	    	return repo.findById(id).get();
	    }
	    

	    
	    // Restful Add Operation
	    public void add(Student student) {
	    	repo.save(student);
	    }
	    
	    //Restful Delete Operation
	    public void delete(Integer id) {
	    	repo.deleteById(id);
	    }
	    
	}


