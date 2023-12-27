package com.example.jobapplysystem.controller;

import com.example.jobapplysystem.model.Management;
import com.example.jobapplysystem.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/management")
public class ManagementController {
      @Autowired
    private final ManagementService managementService;
    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @PostMapping("/addManagement")
    public Management addManagement(@RequestBody Management management) {
        return managementService.addManagement(management);
    }
    
}
