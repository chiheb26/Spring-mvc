package com.mvc.service;

public class LoginService {
	
	public boolean isValidUser(String name, String password) {
		if(name.equals("test")&& password.equals("pass")) {
			return true;
		}else  {
			return false;
		}
	}
}
