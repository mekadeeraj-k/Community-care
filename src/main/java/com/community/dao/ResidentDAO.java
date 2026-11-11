
package com.community.dao;

import com.community.controller.ResidentController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.community.model.Resident;

import jakarta.transaction.Transactional;

@Component
public class ResidentDAO {

	@Autowired
    SessionFactory sessionFactory;
	
	@Autowired
	ResidentController residentController;


    @Transactional
    public String signup(Resident resident) {

        Session session = sessionFactory.getCurrentSession();

        session.persist(resident);

        return "Resident registered successfully";
    }
    
    @Transactional
    public Resident getResidentByEmail(String email) {

        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(
            "FROM Resident WHERE email = :email", Resident.class)
            .setParameter("email", email)
            .uniqueResult();
    }
    
    @Transactional
    public Resident getResidentById(long residentId) {
    	
    	Session session = sessionFactory.getCurrentSession();
    	
    	return session.createQuery(
    			"FROM Resident WHERE residentId = :residentId", Resident.class)
    			.setParameter("residentId", residentId)
    			.uniqueResult();
    }
    
}
