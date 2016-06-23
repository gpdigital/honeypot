package com.gpdigital.honeypot.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gpdigital.honeypot.entity.GPBrands;

public interface GPBrandsDao extends CrudRepository<GPBrands, String> {
	@Query("FROM GPBrands a " + "WHERE a.brandName = :brandName")
	public GPBrands findBrandNameByName(@Param("brandName") String brandName);
	
	@Query("FROM GPBrands a " + "WHERE a.brandId = :brandId")
	public GPBrands findBrandNameById(@Param("brandId") String brandId);
}
