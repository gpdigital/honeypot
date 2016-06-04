package com.gpdigital.honeypot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gpdigital.honeypot.entity.GPFbPages;

public interface GPFbPagesDao extends CrudRepository<GPFbPages, String>{

	@Query("FROM GPFbPages a " + "WHERE a.brandId = :brandId")
	public List<GPFbPages> findFBPagesByBrandId(@Param("brandId") String brandId);
}
