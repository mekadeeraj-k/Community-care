package com.community.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.community.dao.ComplaintDAO;
import com.community.dao.ResidentDAO;
import com.community.model.Complaint;
import com.community.model.Resident;

@Component
public class ComplaintService {
	
	@Autowired
	ComplaintDAO complaintDAO;
	
	@Autowired
	ResidentDAO residentDAO;
	
	public String saveComplaint(Complaint complaint, long residentId) {
		Resident residentById = residentDAO.getResidentById(residentId);
		complaint.setResident(residentById);
		complaint.setStatus("PENDING");
		complaint.setCreatedAt(LocalDateTime.now().withNano(0));
		complaint.setUpdatedAt(LocalDateTime.now().withNano(0));
	
		return complaintDAO.saveComplaints(complaint);
	}
	
	public List<Complaint> showAllComplaints(long residentId) {
		List<Complaint> allComplaints = complaintDAO.showAllComplaints(residentId);
		return allComplaints;
	}
	
	public Complaint getComplaintById(long complaintId) {
	    return complaintDAO.getComplaintById(complaintId);
	}
	
	public void updateComplaint(Complaint complaint) {
	    complaintDAO.updateComplaint(complaint);
	}
	
	public void cancelComplaint(long complaintId) {
		complaintDAO.cancelComplaint(complaintId);
	}
}
