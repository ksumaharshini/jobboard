package com.example.jobapplysystem.controller;

import com.example.jobapplysystem.model.Student;
import com.example.jobapplysystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/other/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/allstudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("allstudents/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/addstudents")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("allstudents/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // Implement more endpoints as needed
}
