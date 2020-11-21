package com.example.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Boolean saveUser(User user) {
		if(Utils.valdidateUser(user)) {
			try {
				userHistory(user);
				userRepository.save(user);
	            return true;
	       } catch (Exception e) {
	            return false;
	       }
		}
		
		return false;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
		
	}
	
	public void userHistory(User user) {
		Period period = Period.between(user.getRegistrerDate(), LocalDate.now());
		user.setHistory(period.getYears() + " año, " + period.getMonths() + " meses, " + period.getDays() + " dias.");
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	

}
