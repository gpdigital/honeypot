package com.gpdigital.honeypot.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseControllerAbstract {
	protected String getUserName(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName().trim();
	}
}
