
package com.community.controller;

import com.community.service.ComplaintService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.community.model.Complaint;
import com.community.model.Resident;
import com.community.service.ResidentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ResidentController {

    private final ComplaintService complaintService;
	@Autowired
    ResidentService residentService;

	ResidentController(ComplaintService complaintService) {
		this.complaintService = complaintService;
	}

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest request) {

    	String residentName = request.getParameter("residentName");
    	String email = request.getParameter("email");
    	String contactNumber = request.getParameter("contactNumber");
    	String password = request.getParameter("password");
    	String confirmPassword = request.getParameter("confirmPassword");
    	String flatNumber = request.getParameter("flatNumber");
        residentService.signupResident( residentName,email,password,contactNumber,flatNumber);
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String residentLogin(HttpServletRequest request ) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Resident login = residentService.loginResident(email, password);
        if (login != null) {
        	HttpSession session = request.getSession();
        	session.setAttribute("residentId", login.getResidentId());
            return "redirect:/community/resident-dashboard";
        }
        return "redirect:/index.jsp";
    }
    
    @GetMapping("/resident-dashboard")
    public String residentDashboard(HttpServletRequest request) {

        HttpSession session = request.getSession();

        int residentId = (int) session.getAttribute("residentId");
        List<Complaint> allComplaints = complaintService.showAllComplaints(residentId);

        Resident resident = residentService.getResidentById(residentId);

        request.setAttribute("complaints", allComplaints);
        request.setAttribute("resident", resident);

        return "resident-dashboard";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
