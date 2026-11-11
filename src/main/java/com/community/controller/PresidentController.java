
package com.community.controller;

import com.community.service.PresidentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PresidentController {

    private final PresidentService presidentService;

	PresidentController(PresidentService presidentService) {
		this.presidentService = presidentService;
	}

	@PostMapping("/admin-login")
    public String login(HttpServletRequest request) {
        String email =request.getParameter("email");
        String password =request.getParameter("password");
        boolean login = presidentService.login(email, password);
        if(login) {
        	return "redirect:/community/president-dashboard";        	
        }
        return "redirect:/community/admin-login";
    }
	
	@GetMapping("/admin-login")
	public String adminLoginPage() {
	    return "admin-login";
	}
	
	@GetMapping("/president-dashboard")
    public String presidentDashboard() {
    	return "president-dashboard";
    }
	
}
