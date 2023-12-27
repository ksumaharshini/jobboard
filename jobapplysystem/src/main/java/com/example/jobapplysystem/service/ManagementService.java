package com.example.jobapplysystem.service;

import com.example.jobapplysystem.model.Management;
import com.example.jobapplysystem.model.AuthRequest;

public interface ManagementService {

    // Other methods...
    Management addManagement(Management management);
    boolean authenticateManagement(AuthRequest authRequest);

    // void changeStudentStatus(Long studentId, String newStatus);

    // void changeJobListingStatus(Long jobListingId, String newStatus);
}
