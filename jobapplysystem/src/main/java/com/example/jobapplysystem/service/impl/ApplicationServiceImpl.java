// ApplicationServiceImpl.java
package com.example.jobapplysystem.service.impl;

import com.example.jobapplysystem.model.Application;
//import com.example.jobapply.model.JobListing;
import com.example.jobapplysystem.repository.ApplicationRepository;
import com.example.jobapplysystem.service.ApplicationService;

import jakarta.persistence.EntityNotFoundException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    //@Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application applyForJob(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getApplicationsForJob(Long jobListingId) {
        // Implement logic to get applications for a specific job listing
        // You can use the applicationRepository to query the database
         return applicationRepository.findByJobListingId(jobListingId);
    }

    @Override
    public List<Application> getApplicationsByStudent(String studentRegistrationNumber) {
        return applicationRepository.findByStudentRegistrationNumber(studentRegistrationNumber);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
	public Application updateStudentStatus(long ApplicationId, String studentstatus) {
		
		Application application = applicationRepository.findById(ApplicationId)
                .orElseThrow(() -> new EntityNotFoundException("Application not found with id: " + ApplicationId));
        
        application.setStudentstatus(studentstatus);
        return applicationRepository.save(application);
    }
    @Override
    public void deleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }
}
