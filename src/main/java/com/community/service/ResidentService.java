
package com.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.community.dao.ResidentDAO;
import com.community.model.Resident;

@Component
public class ResidentService {

    @Autowired
    ResidentDAO residentDAO;
    
    public Resident loginResident(String email, String password) {

        Resident resident = residentDAO.getResidentByEmail(email);

        if (resident != null && resident.getPassword().equals(password)) {
            return resident;
        }
        return null;
    }

    public String signupResident(String residentName, String email,String password,String contactNumber,String flatNumber) {

        Resident resident = new Resident( residentName,email,password,contactNumber,flatNumber);

        return residentDAO.signup(resident);
    }
    
    public Resident getResidentById(int residentId) {
        return residentDAO.getResidentById(residentId);
    }
}
