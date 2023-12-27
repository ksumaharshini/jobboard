// JobListingService.java
package com.example.jobapplysystem.service;

import com.example.jobapplysystem.model.JobListing;

import java.util.List;

public interface JobListingService {

    JobListing createJobListing(JobListing jobListing);

    //JobListing updateJobListing(Long jobListingId, JobListing updatedJobListing);
    public JobListing updateJobListingStatus(long jobListingId,String status);
    void deleteJobListing(Long jobListingId);

    List<JobListing> getAllJobListings();
    List<JobListing> getJobListingsByDepartment(String department);

    JobListing getJobListingById(Long jobListingId);
        // Other method declarations...
    
        List<Long> getJobListingIdsByDepartment(String department);
    

    // Define custom methods as needed
}

