package com.community.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.community.model.Complaint;

import jakarta.transaction.Transactional;

@Component
public class ComplaintDAO {

	@Autowired
	SessionFactory sessionFactory;



	@Transactional
	public String saveComplaints(Complaint complaint) {
		Session session = sessionFactory.getCurrentSession();
		
		session.persist(complaint);
		
		return "Complaint Saved Successfully";
	}
	
	@Transactional
	public List<Complaint> showAllComplaints(long residentId) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery(
				"FROM Complaint c WHERE c.resident.residentId = :residentId",Complaint.class)
				.setParameter("residentId", residentId)
				.getResultList();
	}
	
	@Transactional
	public Complaint getComplaintById(long complaintId) {
	    Session session = sessionFactory.getCurrentSession();

	    return session.find(Complaint.class, complaintId);
	}
	
	@Transactional
	public void updateComplaint(Complaint complaint) {
	    Session session = sessionFactory.getCurrentSession();

	    session.merge(complaint);
	}
	
	@Transactional
	public void cancelComplaint(long complaintId) {
		Session session = sessionFactory.getCurrentSession();
		Complaint complaint = session.find( Complaint.class,complaintId);
		complaint.setStatus("CANCELLED");
	}
	
	
	
	
	
	
	
	
	
}
