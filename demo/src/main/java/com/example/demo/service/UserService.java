package com.example.demo.service;

import java.util.List;

import com.example.demo.persistance.entities.User;


public interface UserService {

	public Boolean saveUser(User user);
	public List<User> findAll();
	public void deleteUser(Integer email);
}
