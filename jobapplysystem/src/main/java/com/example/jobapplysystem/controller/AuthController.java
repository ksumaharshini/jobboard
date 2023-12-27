package com.example.jobapplysystem.controller;

import com.example.jobapplysystem.model.AuthRequest;
import com.example.jobapplysystem.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/verify")
public class AuthController {
 @Autowired
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/student")
    public ResponseEntity<String> authenticateStudent(@RequestBody AuthRequest authRequest) {
        // Implement authentication logic for students
        boolean isStudentAuthenticated = authenticationService.authenticateStudent(authRequest);
        
        if (isStudentAuthenticated) {
            return ResponseEntity.ok("Student authentication successful");
        } else {
            return ResponseEntity.status(401).body("Student authentication failed");
        }
    }

    @PostMapping("/management")
    public ResponseEntity<String> authenticateManagement(@RequestBody AuthRequest authRequest) {
        // Implement authentication logic for management
        boolean isManagementAuthenticated = authenticationService.authenticateManagement(authRequest);
        
        if (isManagementAuthenticated) {
            return ResponseEntity.ok("Management authentication successful");
        } else {
            return ResponseEntity.status(401).body("Management authentication failed");
        }
    }
}

