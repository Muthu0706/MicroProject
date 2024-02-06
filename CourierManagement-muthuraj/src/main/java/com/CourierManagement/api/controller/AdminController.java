package com.CourierManagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CourierManagement.api.entity.CourierStaff;
import com.CourierManagement.api.entity.Parcel;
import com.CourierManagement.api.request.CourierDetails;
import com.CourierManagement.api.response.CourierDetailsResponse;
import com.CourierManagement.api.service.CourierStaffService;
import com.CourierManagement.api.service.ParcelService;
import com.CourierManagement.api.service.UserService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ParcelService parcelService;

    @Autowired
    private CourierStaffService courierstaffService;


    @GetMapping("/courier-details")
    public ResponseEntity<List<CourierDetailsResponse>> getCourierDetails() {
        List<Parcel> parcels = parcelService.getAllParcels();
        List<CourierDetailsResponse> courierDetailsList = new ArrayList<>();
        List<CourierStaff> availableStaffList = courierstaffService.getAllStaffNamess();


        for (Parcel parcel : parcels) {
            CourierDetailsResponse courierDetails = new CourierDetailsResponse();
            courierDetails.setSenderName(parcel.getUser().getUsername());
            System.out.println(parcel.getUser().getUsername());
            courierDetails.setReceiverName(parcel.getRecipientName());
            System.out.println(parcel.getRecipientName());
            courierDetails.setParcelId(parcel.getId());
            courierDetails.setCost(parcel.getCost());
            courierDetails.setStaffNameFromParcel(availableStaffList);
            courierDetails.setStatus(parcel.getStatus());
            courierDetailsList.add(courierDetails);
        }

        return new ResponseEntity<>(courierDetailsList, HttpStatus.OK);
    }

    
    
    @PutMapping("/change-status/{courierId}")
    public ResponseEntity<String> changeCourierStatus(@PathVariable Long courierId) {
       
        parcelService.changeCourierStatus(courierId, "Delivered");

        return new ResponseEntity<>("Courier status changed to Delivered", HttpStatus.OK);
    }

  
    @GetMapping("/staff-names")
    public ResponseEntity<List<String>> getStaffNames() {
        List<String> staffNames = courierstaffService.getAllStaffNames();
        return new ResponseEntity<>(staffNames, HttpStatus.OK);
    }
    
    

    @GetMapping("/courier-details/{staffName}")
    public ResponseEntity<CourierDetails> getCourierDetails(@PathVariable String staffName) {
        
        String staffPhoneNumber = courierstaffService.getStaffPhoneNumber(staffName); 

        List<Parcel> parcels = parcelService.getParcelsByStaffName(staffName);
        String courierDetails = generateCourierDetails(parcels);

        CourierDetails details = new CourierDetails();
        details.setStaffName(staffName);
        details.setStaffPhoneNumber(staffPhoneNumber);
        details.setCourierDetails(courierDetails);

        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    private String generateCourierDetails(List<Parcel> parcels) {
    	
        StringBuilder details = new StringBuilder();

        for (Parcel parcel : parcels) {
            details.append("Parcel ID: ").append(parcel.getId())
                   .append(", Recipient: ").append(parcel.getRecipientName())
                   .append(", Status: ").append(parcel.getStatus())
                   .append("\n");
        }

        return details.toString();
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
