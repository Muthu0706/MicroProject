 package com.CourierManagement.api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CourierManagement.api.entity.Parcel;
import com.CourierManagement.api.entity.User;
import com.CourierManagement.api.repository.ParcelRepository;
import com.CourierManagement.api.repository.UserRepository;
import com.CourierManagement.api.request.ParcelRequest;
import com.CourierManagement.api.service.ParcelService;
import com.CourierManagement.api.service.UserService;

import jakarta.servlet.http.HttpSession;



@RestController
@RequestMapping("/api/login/user/parcels")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;
    
    @Autowired
    private ParcelRepository parcelRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JavaMailSender javaMailSender;
    
//    //@PathVariable Long userId
//    @PostMapping("/create")
//    public ResponseEntity<String> createParcel(HttpSession session, @RequestBody ParcelRequest parcelRequest) {
//        
//    	
//    	Long userId = (Long) session.getAttribute("userId");
//        Optional<User> userOptional = userRepository.findById(userId);
//
//        if (userOptional.isPresent()) {
//            
//            parcelService.addParcel(parcelRequest, userOptional.get());
//
//            return ResponseEntity.ok("Parcel created successfully!");
//        } else {
//           
//            return ResponseEntity.badRequest().body("Error: User with ID " + userId + " not found!");
//        }
//  
//    }  
    
    
    
    @PostMapping("/create")
    public ResponseEntity<String> createParcel(HttpSession session, @RequestBody ParcelRequest parcelRequest) {

        Long userId = (Long) session.getAttribute("userId");
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {

            
            Parcel parcel = parcelService.addParcel(parcelRequest, userOptional.get());

           
            sendEmail(userOptional.get(), parcel);

            return ResponseEntity.ok("Parcel created successfully!");
        } else {

            return ResponseEntity.badRequest().body("Error: User with ID " + userId + " not found!");
        }

    }

    private void sendEmail(User user, Parcel parcel) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail()); 
        message.setSubject("Welcome to our courier service");
        message.setText("Dear " + user.getUsername() + ",\n\n"
                + "Thank you for using our courier service. Your parcel has been successfully created!\n\n"
                + "Sender Name: " + parcel.getUser().getUsername() + "\n"
                + "Receiver Name: " + parcel.getRecipientName() + "\n"
                + "Cost: " + parcel.getCost() + "\n\n"
                + "We appreciate your inicitives and look forward to serving you again.");

        javaMailSender.send(message);
    }
    
    
    
    
    
    
    @GetMapping("/all")
    public ResponseEntity<List<Parcel>> getAllParcels(HttpSession session) {
    	
        List<Parcel> parcels = parcelService.getAllParcels();
        return new ResponseEntity<>(parcels, HttpStatus.OK);
    }
    
}

