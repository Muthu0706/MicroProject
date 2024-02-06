package com.CourierManagement.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CourierManagement.api.entity.CourierStaff;
import com.CourierManagement.api.request.CourierStaffRequest;
import com.CourierManagement.api.service.CourierStaffService;

@RestController
@RequestMapping("/api/admin/courier-staff")
public class CourierStaffController {

    @Autowired
    private CourierStaffService courierStaffService;

//    @GetMapping
//    public ResponseEntity<List<CourierStaff>> getAllCourierStaff() {
//        List<CourierStaff> courierStaffList = courierStaffService.getAllCourierStaff();
//        return new ResponseEntity<>(courierStaffList, HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<String> addCourierStaff(@RequestBody CourierStaffRequest courierStaffRequest) {
        courierStaffService.addCourierStaff(courierStaffRequest);
        return ResponseEntity.ok("Courier staff added successfully!");
    }
}

