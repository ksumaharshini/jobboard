package com.example.jobapplysystem.repository;

import com.example.jobapplysystem.model.Management;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementRepository extends JpaRepository<Management, Long> {
    // Add custom queries if needed
     Optional<Management> findByNameAndPasswordAndPosition(String name, String password, String position);
}
