package com.example.jobapplysystem.service.impl;

import com.example.jobapplysystem.model.AuthRequest;
import com.example.jobapplysystem.model.Student;
import com.example.jobapplysystem.repository.StudentRepository;
import com.example.jobapplysystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    @Override
    public boolean authenticateStudent(AuthRequest authRequest) {
        Optional<Student> optionalStudent = studentRepository.findByRegistrationNumberAndNameAndDepartment(
                authRequest.getRegistrationNumber(), authRequest.getName(), authRequest.getDepartment());

        return optionalStudent.isPresent();
    }

    // Implement more methods as needed
}
