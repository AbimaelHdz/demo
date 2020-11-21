package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.persistance.entities.User;
import com.example.demo.persistance.enums.Estatus;
import com.example.demo.service.ReportService;
import com.example.demo.service.UserService;
import com.example.demo.service.Utils;

import net.sf.jasperreports.engine.JRException;

@Controller
public class UserController {
	
	
	
	@Autowired
	UserService userSer;
	
	@Autowired
	ReportService reportService;
	
	@RequestMapping("/index")
	public String findAll(Model model){
		model.addAttribute("users", userSer.findAll());
		
		return "index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RedirectView add(@ModelAttribute("user") User user) {	
		user.setRegistrerDate(LocalDate.now());
		user.setEstatus(Estatus.ACTIVO);

		if (Utils.valdidateUser(user)) {
			userSer.saveUser(user);
		}
				
		
		return new RedirectView("/demo/index");
		
	}
	
	@RequestMapping(value = "/delete/{email}", method = RequestMethod.DELETE)
	public RedirectView handleDeleteUser(@PathVariable Integer email) {
		userSer.deleteUser(email);
		return new RedirectView("/demo/index");
	}
	
	@RequestMapping("/report")
	public RedirectView generateReport(RedirectAttributes redirAttrs) throws FileNotFoundException, JRException{
		
		redirAttrs.addFlashAttribute("success", reportService.generateReport());
		return new RedirectView("/demo/index");
	}

	
	@ModelAttribute("user")
	public User getUser(){
	    return new User();
	}
}
