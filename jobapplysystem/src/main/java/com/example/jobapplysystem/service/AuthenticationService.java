package com.example.jobapplysystem.service;

import com.example.jobapplysystem.model.AuthRequest;
// import com.example.jobapply.model.Student;
// import com.example.jobapply.model.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

//    private static final String String = null;

@Autowired
    private StudentService studentService;

    @Autowired
    private ManagementService managementService;

    public boolean authenticateStudent(AuthRequest authRequest) {
        return studentService.authenticateStudent(authRequest);
    }

    public boolean authenticateManagement(AuthRequest authRequest) {
        
        return managementService.authenticateManagement(authRequest);
    }
}

