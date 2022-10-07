package com.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.models.Student;
import com.mvc.security.UserInfoStatus;
import com.mvc.service.StudentService;
import com.mvc.validation.CustomValidator;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	CustomValidator customValidator;
	@Autowired
	UserInfoStatus userInfoSttatus;
	 @RequestMapping("/") 
	 public String homePage(ModelMap model) {
		  model.addAttribute("PageTitle","Home Page");
		  
		  return "home"; 
	}
	 
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public String studentsPage(ModelMap model) {
		model.addAttribute("students",studentService.readAllStudents());
		model.addAttribute("PageTitle","Students");
		model.addAttribute("name",userInfoSttatus.getLoggedName());
		System.out.println(userInfoSttatus.isUserLoggedIn());
		return"students";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addStudentsPage(ModelMap model) {
		model.addAttribute("PageTitle","Add Student");
		//throw new RuntimeException("This is a test Exception");
		return"add";
	}
	@RequestMapping(value="/add" , method = RequestMethod.POST)
	public String addStudent( ModelMap model, Student student ) 
	{   
		if(!customValidator.checkNameLength(student.getName())) {
			model.addAttribute("errorName","Name must be more than 2 characters !");
			model.addAttribute("PageTitle","Add Student");
			return"add";
		}
		
		studentService.addStudent(student.getName(), true);
		return"redirect:students";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteStudent(@RequestParam int id) {
		studentService.deleteStudent(id);
		return"redirect:students";
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editStudentPage(ModelMap model, @RequestParam int id) {
		model.addAttribute("student",studentService.getStudentInfo(id));
		model.addAttribute("PageTitle","Update Student");

		return"update";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateStudent(ModelMap model, Student student) {
		if(!customValidator.checkNameLength(student.getName())) {
			model.addAttribute("errorName","Name must be more than 2 characters !");
			model.addAttribute("PageTitle","Update Student");
			return"update";
		}studentService.updateStudent(student.getId(),student.getName(),student.getIsActive());
		return"redirect:students";
	}
	

	
	
	
}
