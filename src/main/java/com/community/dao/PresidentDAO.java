package com.community.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.community.model.President;

import jakarta.transaction.Transactional;

@Component
public class PresidentDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public String login(President president) {
		
		Session session = sessionFactory.getCurrentSession();
		
		return null;
	}
	
}









