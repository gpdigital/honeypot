package com.gpdigital.honeypot.UserDetailsServiceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import com.gpdigital.honeypot.service.GPUsersService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	GPUsersService gpUsersService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName().trim();
		String password = authentication.getCredentials().toString().trim();
		Authentication auth = null;
		/*if (validateUserCredentialsViaSharePoint(username, password)) {
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//			authorities.add(new GrantedAuthorityImpl(users.findByuserId(username).getUserRole()));
//			authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
			try {
				if(artlUserListService.userExists(username)){
					authorities.add(new GrantedAuthorityImpl(artlUserListService.getUserInfo(username).getUserRole()));
				}else{
					authorities.add(new GrantedAuthorityImpl("ROLE_NOT_ALLOWED"));
				}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			auth = new UsernamePasswordAuthenticationToken(username, password, authorities);
			return auth;
		} else {
			return null;
		}*/
		if(gpUsersService.validateCredentials(username, password)!=null){
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
			auth = new UsernamePasswordAuthenticationToken(username, password, authorities);
		}else{
			return null;
		}
		
		return auth;
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
/*
	private boolean validateUserCredentialsViaSharePoint(String username, String password) {
		try {
			return SharepointAuth.checkCredentials(username, password) == 200 ? true : false;
		} catch (IOException e) {
			return false;
		}
	}
	*/
}
