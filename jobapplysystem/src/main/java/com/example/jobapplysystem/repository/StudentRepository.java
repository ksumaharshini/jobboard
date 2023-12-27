package com.example.jobapplysystem.repository;

import com.example.jobapplysystem.model.Student;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom query to find students by department
    List<Student> findByDepartment(String department);

    // Custom query to check if a student with the given registration number exists
    boolean existsByRegistrationNumber(String registrationNumber);
    Optional<Student> findByRegistrationNumberAndNameAndDepartment(String registrationNumber,String name, String department);

}

