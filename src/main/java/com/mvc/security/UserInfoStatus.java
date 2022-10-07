package com.mvc.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserInfoStatus {
	
	public String getLoggedName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			return (((UserDetails) principal).getUsername());
		}
		return principal.toString();
		
	}
	
	public boolean isUserLoggedIn() {
		
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			return true;
		}
		return false;
	}
}
