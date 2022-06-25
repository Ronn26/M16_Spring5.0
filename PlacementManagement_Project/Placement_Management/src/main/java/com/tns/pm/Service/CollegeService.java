package com.tns.pm.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.pm.Repository.CollegeRepository;
import com.tns.pm.entities.College;


@Service
@Transactional
public class CollegeService 
{	
		@Autowired	
		private CollegeRepository repo;
		
	    // Restful Search All Operation
	    public List<College> listAll() {
	    	return repo.findAll();	
	    }
	    
	    // Restful Search Operation
	    public College searchById(Integer id) {
	    	return repo.findById(id).get();
	    }
	    
	    //Restful Add All Operation
	    public List<College> addAll(List<College> list) {
	    	return repo.saveAll(list);
	    }
	    
	    // Restful Add Operation
	    public void add(College college) {
	    	repo.save(college);
	    }
	    
	    //Restful Delete Operation
	    public void delete(Integer id) {
	    	repo.deleteById(id);
	    }

}
	

