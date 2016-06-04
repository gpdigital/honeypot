package com.gpdigital.honeypot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GP_FB_PAGES")

public class GPFbPages implements Serializable{
	
	
	/**
	 * 
	 */
	
	
	
	private static final long serialVersionUID = 4193438276415249559L;

	public GPFbPages(String fbPageName, String fbPageId, String brandId) {
		super();
		this.fbPageName = fbPageName;
		this.fbPageId = fbPageId;
		this.brandId = brandId;
	}
	
	

	public GPFbPages() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Id
	@Column(name = "FB_PAGEID")
	private String fbPageId;

	@Column(name = "FB_PAGENAME")
	private String fbPageName;
	
	@Column(name = "BRAND_ID")
	private String brandId;

	public String getFbPageName() {
		return fbPageName;
	}



	public void setFbPageName(String fbPageName) {
		this.fbPageName = fbPageName;
	}



	public String getFbPageId() {
		return fbPageId;
	}



	public void setFbPageId(String fbPageId) {
		this.fbPageId = fbPageId;
	}



	public String getBrandId() {
		return brandId;
	}



	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	
	
	
}
