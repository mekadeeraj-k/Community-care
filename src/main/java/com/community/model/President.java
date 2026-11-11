package com.community.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "presidents")
public class President {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long presidentId;
	
	@Column(name = "president_name")
	private String presidentName;
	
	@Column(unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(unique = true)
	private String contactNumber;
	
	public President() {
		
	}

	
	
	public President(String contactNumber, String password) {
		this.contactNumber = contactNumber;
		this.password = password;
	}



	public President(long presidentId, String presidentName, String email, String password, String contactNumber) {
		this.presidentId = presidentId;
		this.presidentName = presidentName;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
	}

	public President(String presidentName, String email, String password, String contactNumber) {
		this.presidentName = presidentName;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
	}

	public long getPresidentId() {
		return presidentId;
	}

	public void setPresidentId(long presidentId) {
		this.presidentId = presidentId;
	}

	public String getPresidentName() {
		return presidentName;
	}

	public void setPresidentName(String presidentName) {
		this.presidentName = presidentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "President [presidentId=" + presidentId + ", presidentName=" + presidentName + ", email=" + email
				+ ", password=" + password + ", contactNumber=" + contactNumber + "]";
	}
	
	
}
