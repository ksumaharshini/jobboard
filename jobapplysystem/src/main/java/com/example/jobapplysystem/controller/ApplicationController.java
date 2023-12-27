// ApplicationController.java
package com.example.jobapplysystem.controller;

import com.example.jobapplysystem.model.Application;
import com.example.jobapplysystem.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/apply")
    public Application applyForJob(@RequestBody Application application) {
        return applicationService.applyForJob(application);
    }

    @PostMapping("/apply/{jobListingId}")
    public Application applyForJobWithListingId(@PathVariable Long jobListingId, @RequestBody Application application) {
        application.setJobListingId(jobListingId);
        return applicationService.applyForJob(application);
    }

    @GetMapping("/job/{jobListingId}")
    public List<Application> getApplicationsForJob(@PathVariable Long jobListingId) {
        return applicationService.getApplicationsForJob(jobListingId);
    }

    @GetMapping("/student/{studentRegistrationNumber}")
    public List<Application> getApplicationsByStudent(@PathVariable String studentRegistrationNumber) {
        return applicationService.getApplicationsByStudent(studentRegistrationNumber);
    }

    @GetMapping("/all")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @DeleteMapping("/delete/{applicationId}")
    public void deleteApplication(@PathVariable Long applicationId) {
        applicationService.deleteApplication(applicationId);
    }

    @PutMapping("/status/{applicationid}")
    public ResponseEntity<Application> updateStudentStatus(@PathVariable Long applicationid,
                                                           @RequestParam String newStatus) {
        Application updatedApplication = applicationService.updateStudentStatus(applicationid, newStatus);
        return ResponseEntity.ok(updatedApplication);
    }
}
