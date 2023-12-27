package com.example.jobapplysystem.service;

import com.example.jobapplysystem.model.AuthRequest;
import com.example.jobapplysystem.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student saveStudent(Student student);

    void deleteStudent(Long id);
    boolean authenticateStudent(AuthRequest authRequest);

    // Add more methods as needed

}
