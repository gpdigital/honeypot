package com.gpdigital.honeypot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GP_USERS")
public class GPUsers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6928447778313673042L;
	
	
	
	public GPUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GPUsers(String userId, String username, String password, String brandId, String macAddress) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.brandId = brandId;
		this.macAddress = macAddress;
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "BRAND_ID")
	private String brandId;
	
	@Column(name = "MAC_ADDRESS")
	private String macAddress;



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
	
	

}
