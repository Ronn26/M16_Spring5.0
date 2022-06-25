package com.tns.pm.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.pm.Repository.PlacementRepository;
import com.tns.pm.entities.Placement;

@Service
@Transactional
public class PlacementService {
	
	@Autowired	
	private PlacementRepository repo;
	
    // Restful Search All Operation
    public List<Placement> listAll(Integer id) {
    	return repo.findByCollegeId(id);
    }
    
    // Restful Search Operation
    public Placement searchById(Integer id) {
    	return repo.findById(id).get();
    }
    

    
    // Restful Add Operation
    public void add(Placement placement) {
    	repo.save(placement);
    }
    
    //Restful Delete Operation
    public void delete(Integer id) {
    	repo.deleteById(id);
    }
    
}
