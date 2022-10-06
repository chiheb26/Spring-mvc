package com.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
		
	private LoginService loginService=new LoginService();
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
		//@ResponseBody
		public String loginPage(ModelMap model) {
		model.addAttribute("PageTitle","Login Page");

			return "login";
		}
		
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public String getLoginInfo(@RequestParam String name,
				@RequestParam String password,
				ModelMap model) {
			//System.out.println(name);
			if(!loginService.isValidUser(name, password)) {
				model.put("errorMsg", "Invalid username and password !");
				model.addAttribute("PageTitle","Login Page");

				return "login";
			}
			model.put("name", name);
			return "redirect:students";
		}
		@RequestMapping("/home")
		public String homePage(ModelMap model) {
			model.addAttribute("PageTitle","Home Page");

			return "home";
		}
		
}
