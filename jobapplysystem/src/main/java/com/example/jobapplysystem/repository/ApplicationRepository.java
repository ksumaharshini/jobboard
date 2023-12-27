// ApplicationRepository.java
package com.example.jobapplysystem.repository;

import com.example.jobapplysystem.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByJobListingId(Long jobListingId);
    List<Application> findByStudentRegistrationNumber(String studentRegistrationNumber);
    // You can add more custom query methods here if needed
}
