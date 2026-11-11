package com.community.controller;

import java.time.LocalDateTime;
import java.util.concurrent.CompletionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.community.model.Complaint;
import com.community.service.ComplaintService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ComplaintController {

	@Autowired
	ComplaintService complaintService;
	
	@PostMapping("/submit-complaint")
	public String submitComplaint(HttpServletRequest request) {
		
		String complaintTitle = request.getParameter("complaintTitle");
		String complaintType = request.getParameter("complaintType");
		String description = request.getParameter("description");
		
		Complaint complaint = new Complaint(complaintTitle, complaintType, description);
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("residentId");
		long residentId = id;
		
		complaintService.saveComplaint(complaint, residentId);
		return "redirect:/community/resident-dashboard";
	}
	
	@GetMapping("/complaintById")
	public String getComplaintById(@RequestParam("complaintId") long complaintId, Model model) {
	    Complaint complaintById = complaintService.getComplaintById(complaintId);
	    model.addAttribute("complaint", complaintById);
	    return "update-complaint";
	}
	
	@PostMapping("/updateComplaint")
	public String updateComplaint(HttpServletRequest request) {

	    long complaintId = Long.parseLong(request.getParameter("complaintId"));
	    String complaintTitle = request.getParameter("complaintTitle");
	    String complaintType = request.getParameter("complaintType");
	    String description = request.getParameter("description");
	    Complaint complaint = complaintService.getComplaintById(complaintId);
	    System.out.println("Complaint found: " + complaint);
	    
	    HttpSession session = request.getSession();
	    int residentId = (int) session.getAttribute("residentId");

	    if (complaint == null || complaint.getResident().getResidentId() != residentId) {
	        return "redirect:/community/resident-dashboard";
	    }
	    if (!"PENDING".equals(complaint.getStatus())) {
	        return "redirect:/community/resident-dashboard";
	    }
	    
	    complaint.setComplaintTitle(complaintTitle);
	    complaint.setComplaintType(complaintType);
	    complaint.setDescription(description);
	    complaint.setUpdatedAt(LocalDateTime.now().withNano(0));
	    
	    complaintService.updateComplaint(complaint);
	    
	    return "redirect:/community/resident-dashboard";

	}
	
	@PostMapping("/cancelComplaint")
	public String cancelComplaint(@RequestParam("complaintId") long complaintId, HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 int id = (int) session.getAttribute("residentId");
		 long residentId = id;
		 Complaint complaintById = complaintService.getComplaintById(residentId);
		    if (complaintById == null ||
		            complaintById.getResident().getResidentId() != residentId) {
		            return "redirect:/community/resident-dashboard";
		        }
		        if ("PENDING".equals(complaintById.getStatus())) {
		            complaintService.cancelComplaint(complaintId);
		        }
		        return "redirect:/community/resident-dashboard";
		    
	}
	
	
	
	
	
	
	
	
	
	
	
}
