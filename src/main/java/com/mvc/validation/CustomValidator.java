package com.mvc.validation;

import org.springframework.stereotype.Service;

@Service
public class CustomValidator {
	
	public boolean checkNameLength(String name) {
		if(name.length()>=3) {
			return true;
		}
		return false;
			
	}
}
