package com.CourierManagement.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourierManagement.api.entity.CourierStaff;
import com.CourierManagement.api.repository.CourierStaffRepository;
import com.CourierManagement.api.request.CourierStaffRequest;

@Service
public class CourierStaffService {

    @Autowired
    private CourierStaffRepository staffRepository;
    

    public void addCourierStaff(CourierStaffRequest courierStaffRequest) {
        CourierStaff courierStaff = new CourierStaff();
        courierStaff.setStaffName(courierStaffRequest.getStaffName());
        courierStaff.setPhoneNumber(courierStaffRequest.getPhoneNumber());

        staffRepository.save(courierStaff);
    }
    

    public List<String> getAllStaffNames() {
        List<CourierStaff> staffList = staffRepository.findAll();
        return staffList.stream().map(CourierStaff::getStaffName).collect(Collectors.toList());
    }
    
    public List<CourierStaff> getAllStaffNamess() {
        return staffRepository.findAll();
    }
    
    public String getStaffPhoneNumber(String staffName) {
        CourierStaff staff = staffRepository.findByStaffName(staffName);
        return (staff != null) ? staff.getPhoneNumber() : null;
    }

    
}
