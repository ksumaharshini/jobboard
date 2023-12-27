// ApplicationService.java
package com.example.jobapplysystem.service;

import com.example.jobapplysystem.model.Application;

import java.util.List;

public interface ApplicationService {
    Application applyForJob(Application application);
    List<Application> getApplicationsForJob(Long jobListingId);
    List<Application> getApplicationsByStudent(String studentRegistrationNumber);
    List<Application> getAllApplications();
    public Application updateStudentStatus(long ApplicationId,String studentstatus);
    void deleteApplication(Long applicationId);
}
