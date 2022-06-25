package com.tns.pm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tns.pm.Repository.UserRepository;
import com.tns.pm.entities.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> listAll() {
		return repo.findAll();
	}

	public void add(User user) {
		repo.save(user);
	}

	public User searchById(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}