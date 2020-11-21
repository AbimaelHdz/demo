package com.example.demo.service;

import java.util.regex.Pattern;

import com.example.demo.persistance.entities.User;

public class Utils {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static boolean validateName(String name) {
		String expression = "^[a-zA-Z\\s]{0,10}+"; 
	    return name.matches(expression);     
	}
	
	public static boolean validateEmail(String email) {
		String expression = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
	    return email.matches(expression);     
	}

	public static boolean valdidateUser(User user) {
		return (validateName(user.getName()) && validateEmail(user.getEmail())
				&& user.getName() != "" && user.getEmail() != "" ? true : false);
	}
}
