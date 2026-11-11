package com.community.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaints")
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long complaintId;
	
	private String complaintTitle;
	
//	issue
	private String complaintType;
	
	private String description;
	
	private String status;
	
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime createdAt;

	@Column(columnDefinition = "DATETIME")
	private LocalDateTime updatedAt;
	
	@ManyToOne
	private Resident resident;

	public Complaint(String complaintTitle, String complaintType, String description) {
		this.complaintTitle = complaintTitle;
		this.complaintType = complaintType;
		this.description = description;
	}

	public Complaint() {

	}

	public long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(long complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintTitle() {
		return complaintTitle;
	}

	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", complaintTitle=" + complaintTitle + ", complaintType="
				+ complaintType + ", description=" + description + ", status=" + status + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", resident=" + resident + "]";
	}
	
	
	
	
}
