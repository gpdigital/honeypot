package com.gpdigital.honeypot.service;

import com.gpdigital.honeypot.entity.GPUsers;

public interface GPUsersService {

	public void saveGPUser(GPUsers userName) throws Exception;

	public void deleteGPUser(String userId) throws Exception;
	
	public GPUsers validateCredentials(String username,String password);
	
	public GPUsers getBrandID(String username);
	
}
