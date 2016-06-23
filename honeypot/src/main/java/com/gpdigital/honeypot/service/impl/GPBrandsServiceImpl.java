package com.gpdigital.honeypot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gpdigital.honeypot.dao.GPBrandsDao;
import com.gpdigital.honeypot.entity.GPBrands;
import com.gpdigital.honeypot.service.GPBrandsService;

public class GPBrandsServiceImpl implements GPBrandsService{

	@Autowired
	GPBrandsDao gpBrandDao;
	
	@Override
	public void saveGPBrand(GPBrands gpBrand) throws Exception {
		// TODO Auto-generated method stub
		gpBrandDao.save(gpBrand);
		
	}

	@Override
	public void deleteGPBrand(String brandId) throws Exception {
		// TODO Auto-generated method stub
		gpBrandDao.delete(brandId);
		
	}

	@Override
	public GPBrands findBrandNameByName(String brandName) {
		// TODO Auto-generated method stub
		return gpBrandDao.findBrandNameByName(brandName);
	}
	
	@Override
	public GPBrands findBrandNameById(String brandId) {
		// TODO Auto-generated method stub
		return gpBrandDao.findBrandNameById(brandId);
	}

}
