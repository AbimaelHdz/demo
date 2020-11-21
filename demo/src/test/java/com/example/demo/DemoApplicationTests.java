package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.persistance.entities.User;
import com.example.demo.persistance.enums.Estatus;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect" })
@AutoConfigureTestDatabase
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class DemoApplicationTests {

	@Autowired
	UserService userService;
	
	
	@Test
	void findAll() {
		assertEquals(listUsers().toString(), userService.findAll().toString());
	}

	@Test
	void saveUserSuccess() {
		assertEquals(true, userService.saveUser(createUser("Test")));
	}
	
	@Test
	void saveUserFail() {
		assertEquals(false, userService.saveUser(createUser("Test is failed")));
	}
	
	@Test
	void saveUserFailWhenIsBlank() {
		assertEquals(false, userService.saveUser(createUser("")));
	}
	
	public User createUser(String name) {
		User user = new User();
		user.setId(4);
		user.setName(name);
		user.setEmail("user@email.com");
		user.setHistory("0 año, 2 meses, 15 dias");
		user.setEstatus(Estatus.ACTIVO);
		user.setRegistrerDate(LocalDate.now());
		
		return user;
	}
	
	public List<User> listUsers(){
		List<User> list = new ArrayList<User>();
		
		User juan = new User();
		juan.setId(1);
		juan.setName("Juan");
		juan.setEmail("juan@email.com");
		juan.setHistory("0 año, 0 meses, 0 dias");
		juan.setEstatus(Estatus.ACTIVO);
		juan.setRegistrerDate(LocalDate.now());
		
		User carlos = new User();
		carlos.setId(2);
		carlos.setName("Carlos");
		carlos.setEmail("carlos@email.com");
		carlos.setHistory("0 año, 2 meses, 15 dias");
		carlos.setEstatus(Estatus.INACTIVO);
		carlos.setRegistrerDate(LocalDate.of(2020, 9, 4));
		
		User maria = new User();
		maria.setId(3);
		maria.setName("María");
		maria.setEmail("maria@email.com");
		maria.setHistory("1 año, 5 meses, 30 dias");
		maria.setEstatus(Estatus.SUSPENDIDO);
		maria.setRegistrerDate(LocalDate.of(2019, 5, 20));
		
		list.add(juan);
		list.add(carlos);
		list.add(maria);
		
		return list;
	}
}
