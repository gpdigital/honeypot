package com.gpdigital.honeypot.UserDetailsServiceImpl;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

	/**
	* 
	 */
	private static final long serialVersionUID = 8324244529906159851L;

	private String role;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role;
	}

	public GrantedAuthorityImpl(String role) {
		super();
		this.role = role;
	}

}
