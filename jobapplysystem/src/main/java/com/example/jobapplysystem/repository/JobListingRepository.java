package com.example.jobapplysystem.repository;

import com.example.jobapplysystem.model.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {

    // ... other existing methods ...

    List<JobListing> findByDepartments(String department);
    List<JobListing> findFirstByDepartments(String department);

}
