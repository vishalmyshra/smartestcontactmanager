package com.smart.contact.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.smart.contact.manager.dao.UserRepository;
import com.smart.contact.manager.entities.User;
import com.smart.contact.manager.helper.MessageHelper;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	@RequestMapping("/registration")
	public String getRegistrationPage(Model model) {
		
		model.addAttribute("title","User registration");
		model.addAttribute("user",new User());
		return "registration";
	}
	
	@PostMapping("/do_register")
	public String doRegisterHandler(@Valid @ModelAttribute("user")  User user,BindingResult result, @RequestParam(value = "user_agreement", defaultValue = "false") boolean userAgreement, Model model,HttpSession session) {
	
		try {
			if(!userAgreement) {
				System.out.println("Please agree to terms and conditions.");
				throw new Exception("Please agree to terms and conditions.");
			}
			
			if(result.hasErrors()) {
				model.addAttribute("user",user);
				System.out.println("error" + result.toString());
				return "registration";
			}
			
			//set fields
			user.setEnabled(true);
			user.setUserRole("ROLE_USER");
			user.setProfileImageUrl("default.png");
			
			System.out.println("user"+user);
			
			userRepository.save(user);
			
			//send new user to model so input fields are blank
			
			model.addAttribute("user", new User());
			
			//success message
			session.setAttribute("message", new MessageHelper("alert-success", "registered"));
			return "registration";
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("user",user);
			
			session.setAttribute("message", new MessageHelper("alert-danger"  ,"!registered"));
			return "registration";
			
		}
	}
}
