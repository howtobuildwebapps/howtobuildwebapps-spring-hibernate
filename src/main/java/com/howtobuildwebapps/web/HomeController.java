package com.howtobuildwebapps.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.howtobuildwebapps.domain.User;
import com.howtobuildwebapps.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("message", "Welcome to Howotobuildwebapps Home page!");
		
		return "home/home";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(Model model) {
		User user = new User();
		user.setCreatedDate(new Date());
		user.setEmailId("htbw@gmail.com");
		user.setFirstName("HT");
		user.setLastName("BW");
		user.setPassword("Test123");
		
		userService.saveUser(user);
		
		model.addAttribute("message", userService.getUsers());
		
		return "home/home";
	}
	
}
