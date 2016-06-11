package com.gpdigital.honeypot.service;


import java.util.List;

import com.gpdigital.honeypot.entity.GPFbPages;

public interface GPFbPagesService {

	public void saveGPFbPage(GPFbPages fbPageName) throws Exception;

	public void deleteGPFbPage(String fbPageId) throws Exception;
	
	public List<GPFbPages> findFBPagesByBrandId(String brandId);
	
}
