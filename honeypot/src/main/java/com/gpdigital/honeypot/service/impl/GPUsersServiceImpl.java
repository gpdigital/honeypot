package com.gpdigital.honeypot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gpdigital.honeypot.dao.GPUsersDao;
import com.gpdigital.honeypot.entity.GPUsers;
import com.gpdigital.honeypot.service.GPUsersService;

public class GPUsersServiceImpl implements GPUsersService{

	@Autowired
	GPUsersDao gpUsersdao;
	
	@Override
	public void saveGPUser(GPUsers gpUser) throws Exception {
		// TODO Auto-generated method stub
		gpUsersdao.save(gpUser);
		
	}

	@Override
	public void deleteGPUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		gpUsersdao.delete(userId);
		
	}

	@Override
	public GPUsers validateCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return gpUsersdao.validateCredentials(username, password);
	}

	@Override
	public GPUsers getBrandID(String username) {
		// TODO Auto-generated method stub
		return gpUsersdao.getBrandID(username);
	}
}
