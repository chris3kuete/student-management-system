package net.strive2codejava.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.strive2codejava.sms.entity.Lecturer;
import net.strive2codejava.sms.service.RegisterService;

@Controller
public class RegistrationController {
	
	@Autowired
	public RegisterService registerService;
	
	@GetMapping("/")
	public String WelcomePage() {
		return "welcome_page";
	}
	
	@GetMapping("/register")
	public String getRegistrationPage(Model model) {
		Lecturer mylecturer = new Lecturer();
		model.addAttribute("mylecturer", mylecturer);
		return "registration_page";
	}
	
	@PostMapping("/register")
	public String registerUser(String firstName,String lastName,String subject,String email,String password) {
		
		Lecturer mylect = registerService.createLecturer(firstName, lastName, subject, email, password);
		if(mylect != null) {
			return "lecturer_registered";
		}
		return "notregistered_page";
		
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		Lecturer mylect = new Lecturer();
		model.addAttribute("mylect", mylect);
		return "login_page";
	}
	
	@PostMapping("/login")
	public String loginUser(String email, String password) {
		Lecturer authenticated = registerService.checkUser(email, password);
		if (authenticated != null) {
			return "redirect:/students";
		}
		return "error_page";
	}
	

}
