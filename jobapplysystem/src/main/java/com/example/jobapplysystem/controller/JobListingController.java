package com.example.jobapplysystem.controller;

import com.example.jobapplysystem.model.JobListing;
import com.example.jobapplysystem.service.JobListingService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000" , allowCredentials = "true")
@RequestMapping("/api/joblistings")
public class JobListingController {
     @Autowired
    private final JobListingService jobListingService;

    public JobListingController(JobListingService jobListingService) {
        this.jobListingService = jobListingService;
    }

    @PostMapping("/addjoblisting")
    public JobListing createJobListing(@RequestBody JobListing jobListing) {
        return jobListingService.createJobListing(jobListing);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<JobListing> updateJobListingStatus(@PathVariable Long id, @RequestParam String newStatus) {
        JobListing updatedJobListing = jobListingService.updateJobListingStatus(id, newStatus);
        return ResponseEntity.ok(updatedJobListing);
    }

    @GetMapping("/bydepartment/{department}")
    public List<JobListing> getJobListingsByDepartment(@PathVariable String department) {
        return jobListingService.getJobListingsByDepartment(department);
    }

    @DeleteMapping("/{jobListingId}")
    public void deleteJobListing(@PathVariable Long jobListingId) {
        jobListingService.deleteJobListing(jobListingId);
    }

    @GetMapping("/alljoblisting")
    public List<JobListing> getAllJobListings() {
        return jobListingService.getAllJobListings();
    }
    @GetMapping("/alljoblisting/{jobListingId}")
    public JobListing getJobListingById(@PathVariable Long jobListingId) {
         return jobListingService.getJobListingById(jobListingId);
    }


    @GetMapping("/joblistingid/bydepartment/{department}")
public ResponseEntity<List<Long>> getJobListingIdsByDepartment(@PathVariable String department) {
    List<Long> jobListingIds = jobListingService.getJobListingIdsByDepartment(department);

    if (!jobListingIds.isEmpty()) {
        return ResponseEntity.ok(jobListingIds);
    } else {
        // Handle the case where no job listings are found for the department
        return ResponseEntity.notFound().build();
    }
}
    // Add more endpoints as needed
}
