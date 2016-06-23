package com.gpdigital.honeypot.service;

import com.gpdigital.honeypot.entity.GPBrands;

public interface GPBrandsService {

	public void saveGPBrand(GPBrands gpBrand) throws Exception;

	public void deleteGPBrand(String brandId) throws Exception;

	public GPBrands findBrandNameByName(String brandName);
	
	public GPBrands findBrandNameById(String brandId);
}
