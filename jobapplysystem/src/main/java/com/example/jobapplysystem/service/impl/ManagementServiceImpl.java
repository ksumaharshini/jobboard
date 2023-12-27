package com.example.jobapplysystem.service.impl;

import com.example.jobapplysystem.model.AuthRequest;
import com.example.jobapplysystem.model.Management;
import com.example.jobapplysystem.repository.ManagementRepository;
import com.example.jobapplysystem.service.ManagementService;
import org.springframework.stereotype.Service;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;

//import java.util.Optional;

@Service
public class ManagementServiceImpl implements ManagementService {

    private final ManagementRepository managementRepository;

    //@Autowired
    public ManagementServiceImpl(ManagementRepository managementRepository) {
        this.managementRepository = managementRepository;
    }

    @Override
    public Management addManagement(Management management) {
        // Implement the logic to add a new management member
        // Ensure that you perform any necessary validations
        return managementRepository.save(management);
    }
    @Override
    public boolean authenticateManagement(AuthRequest authRequest) {
        Optional<Management> optionalManagement = managementRepository.findByNameAndPasswordAndPosition(
                authRequest.getName(), authRequest.getPassword(), authRequest.getPosition());

        return optionalManagement.isPresent();
    }
    
}
