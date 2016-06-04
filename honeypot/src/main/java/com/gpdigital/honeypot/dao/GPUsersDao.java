package com.gpdigital.honeypot.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gpdigital.honeypot.entity.GPUsers;

public interface GPUsersDao extends CrudRepository<GPUsers, String>{
	

	@Query("FROM GPUsers a " + "WHERE a.username = :username AND a.password = :password")
	public GPUsers validateCredentials(@Param("username") String username,@Param("password") String password);

}
