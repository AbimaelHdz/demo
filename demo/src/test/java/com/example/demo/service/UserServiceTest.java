package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.persistance.entities.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	List<User> users;
	
	@Mock
	User user;
	
	@Mock
	UserService userService;

	@Test
	public void findAll() {
		Mockito.when(userService.findAll()).thenReturn(users);
		assertEquals(userService.findAll(), users);
	}
	
	@Test
	public void saveSucces() {
		Mockito.when(userService.saveUser(user)).thenReturn(true);
		assertEquals(true, userService.saveUser(user));
	}
	
	@Test
	public void saveFail() {
		Mockito.when(userService.saveUser(user)).thenReturn(false);
		assertEquals(false, userService.saveUser(user));
	}

	
}
