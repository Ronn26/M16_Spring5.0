package com.tns.pm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.pm.entities.Student;

public interface StudentRepository extends JpaRepository < Student, Integer > {

	

}