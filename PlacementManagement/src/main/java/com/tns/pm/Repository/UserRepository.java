package com.tns.pm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.pm.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}