package com.tns.pm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.pm.entities.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
	
}
