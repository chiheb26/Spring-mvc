package com.mvc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.models.Student;

@Service
public class StudentService {
static int studentsNumber=4;
static List<Student> students= new ArrayList<Student>();
static {
	students.add(new Student(1,"a",true));
	students.add(new Student(2,"b",true));
	students.add(new Student(3,"c",true));
	students.add(new Student(4,"d",true));
}

 public List<Student> readAllStudents() {
	 return students;
 
}
 public void addStudent(String name,boolean isActive) {
 students.add(new Student(++studentsNumber,name,isActive));
 } 
 public void deleteStudent(int id) {
	 Iterator<Student> iterator=students.iterator();
	 while(iterator.hasNext()) {
		 Student st=iterator.next();
		 if(st.getId()==id) {
			 iterator.remove();
		 }
	 }

 }
 public Student getStudentInfo(int id) {
	 for(Student student:students) {
		 if(student.getId()==id) {
			 return student;
		 }
	 }
	 return null;
 }
 public void updateStudent(int id,String name,boolean isActive) {
 	
 	Iterator<Student> iterator= students.iterator();
  	while(iterator.hasNext()) {
  		Student student = iterator.next();
  		if(student.getId()==id) {
  			student.setName(name);
  			student.setActive(isActive);
  		}
  	}
}
}