package com.community.service;

import org.springframework.stereotype.Component;

import com.community.dao.PresidentCredentials;


@Component
public class PresidentService {

	public boolean login(String email, String password) {
		return PresidentCredentials.PRESIDENT.getEmail().equals(email) &&
				PresidentCredentials.PRESIDENT.getPassword().equals(password);
	}
	
}









