package com.CourierManagement.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.CourierManagement.api.entity.User;
import com.CourierManagement.api.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    
    
    
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User authenticateUser(String username, String password) {
       
        User user = userRepository.findByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            
            return user;
        } else {
            
            return null;
        }
    }


    public User registerUser(User user) {
    	
    	
    	
        if (isEmailAlreadyRegistered(user.getEmail())) {
           
            throw new RuntimeException("Email is already registered");
        }
        
        User userObj = new User();
        userObj.setAddress(user.getAddress());
        userObj.setEmail(user.getEmail());
        userObj.setPhoneNumber(user.getPhoneNumber());
        userObj.setStatus("active");
        userObj.setPassword(user.getPassword());
        userObj.setUsername(user.getUsername());
        
        return userRepository.save(userObj);
    }

    private boolean isEmailAlreadyRegistered(String email) {
        return userRepository.existsByEmail(email);
    }
    
   
    
    
//    public User getUserByUsername(String username) {
//        return userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
    
   
	
}


