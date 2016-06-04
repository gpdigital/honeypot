package com.gpdigital.honeypot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GP_BRANDS")

public class GPBrands implements Serializable{

	/**
	 * 
	 * 
	 * 
	 */
	
	
	
	private static final long serialVersionUID = 2192394268902238239L;

	public GPBrands(String brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	}

	
	
	public GPBrands() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "BRAND_ID")
	private String brandId;
	
	@Column(name = "BRAND_NAME")
	private String brandName;

	public String getBrandId() {
		return brandId;
	}



	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}



	public String getBrandName() {
		return brandName;
	}



	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	

	
}
