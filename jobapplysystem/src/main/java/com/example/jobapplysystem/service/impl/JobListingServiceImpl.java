// JobListingServiceImpl.java
package com.example.jobapplysystem.service.impl;

import com.example.jobapplysystem.model.JobListing;
import com.example.jobapplysystem.repository.JobListingRepository;
import com.example.jobapplysystem.service.JobListingService;

import jakarta.persistence.EntityNotFoundException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobListingServiceImpl implements JobListingService {

    private final JobListingRepository jobListingRepository;

    // Constructor injection
    //@Autowired
    public JobListingServiceImpl(JobListingRepository jobListingRepository) {
        this.jobListingRepository = jobListingRepository;
    }

    @Override
    public JobListing createJobListing(JobListing jobListing) {
        // Implement the logic to create a job listing
        return jobListingRepository.save(jobListing);
    }
    
    @Override
    public JobListing updateJobListingStatus(long jobListingId, String status) {
        JobListing jobListing = jobListingRepository.findById(jobListingId)
                .orElseThrow(() -> new EntityNotFoundException("JobListing not found with id: " + jobListingId));

        jobListing.setJobListingStatus(status);
        return jobListingRepository.save(jobListing);
    }
    

    @Override
    public void deleteJobListing(Long jobListingId) {
        // Implement the logic to delete a job listing
        jobListingRepository.deleteById(jobListingId);
    }
    @Override
public List<JobListing> getJobListingsByDepartment(String department) {
    return jobListingRepository.findByDepartments(department);
}


    @Override
    public List<JobListing> getAllJobListings() {
        // Implement the logic to retrieve all job listings
        return jobListingRepository.findAll();
    }
    @Override
public List<Long> getJobListingIdsByDepartment(String department) {
    // This is a hypothetical example, adjust it based on your actual data model
    List<JobListing> jobListings = jobListingRepository.findByDepartments(department);
    
    // Extract jobListingIds from the jobListings
    return jobListings.stream()
            .map(JobListing::getJobListingid)
            .collect(Collectors.toList());
}


    @Override
    public JobListing getJobListingById(Long jobListingId) {
        // Implement the logic to retrieve a job listing by ID
        return jobListingRepository.findById(jobListingId).orElse(null);
    }

    // Implement additional methods as needed
}
