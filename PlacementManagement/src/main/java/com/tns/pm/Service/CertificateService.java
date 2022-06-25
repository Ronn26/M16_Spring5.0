package com.tns.pm.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tns.pm.Repository.CertificateRepository;
import com.tns.pm.entities.Certificate;

@Service
@Transactional
public class CertificateService {
	
	@Autowired	
	private CertificateRepository repo;
	
    // Restful Search All Operation
    public List<Certificate> listAll() {
    	return repo.findAll();
    }
    
    // Restful Search Operation
    public Certificate searchById(Integer id) {
    	return repo.findById(id).get();
    }
    

    
    // Restful Add Operation
    public void add(Certificate certificate) {
    	repo.save(certificate);
    }
    
    //Restful Delete Operation
    public void delete(Integer id) {
    	repo.deleteById(id);
    }
    
}
