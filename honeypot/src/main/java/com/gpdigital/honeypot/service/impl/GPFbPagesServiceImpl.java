package com.gpdigital.honeypot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gpdigital.honeypot.dao.GPFbPagesDao;
import com.gpdigital.honeypot.entity.GPFbPages;
import com.gpdigital.honeypot.service.GPFbPagesService;

public class GPFbPagesServiceImpl implements GPFbPagesService{

	@Autowired
	GPFbPagesDao gpFbPagesDao;
	
	@Override
	public void saveGPFbPage(GPFbPages fbPage) throws Exception {
		// TODO Auto-generated method stub
		gpFbPagesDao.save(fbPage);
		
	}

	@Override
	public void deleteGPFbPage(String fbPageId) throws Exception {
		// TODO Auto-generated method stub
		gpFbPagesDao.delete(fbPageId);
	}

	@Override
	public List<GPFbPages> findFBPagesByBrandId(String brandId) {
		// TODO Auto-generated method stub
		return gpFbPagesDao.findFBPagesByBrandId(brandId);
	}


}
