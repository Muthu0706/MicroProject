package com.CourierManagement.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CourierManagement.api.entity.User;
import com.CourierManagement.api.request.LoginRequest;
import com.CourierManagement.api.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private UserService userService;

   
   

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpSession session, @RequestBody LoginRequest loginRequest) {
       
        User authenticatedUser = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (authenticatedUser != null) {
          
            session.setAttribute("user", authenticatedUser);

          
            Long userId = authenticatedUser.getId();
            session.setAttribute("userId", userId);

            return ResponseEntity.ok("Login successful!");
        } else {
           
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    
    
    
    @PostMapping("/admin")
    public ResponseEntity<String> loginAdmin(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

       
        if ("admin".equals(username) && "adminpassword".equals(password)) {
            return new ResponseEntity<>("Admin login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid admin credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}

