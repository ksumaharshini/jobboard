package com.example.jobapplysystem.model;

import jakarta.persistence.*;

// import java.util.HashSet;
// import java.util.Set;
import com.example.jobapplysystem.model.Management;


@Entity
@Table(name = "management")
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "position")
    private String position;



    public Management(String name, String password, String position) {
        this.name = name;
        this.password = password;
        this.position = position;
    }
    public Management() {
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getPosition() {
        return position;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    @Override
    public String toString() {
        return "Management [id=" + id + ", name=" + name + ", password=" + password + ", position=" + position + "]";
    }
    

    // public Set<String> getStudentStatus() {
    //     return studentStatus;
    // }

    // public void setStudentStatus(Set<String> studentStatus) {
    //     this.studentStatus = studentStatus;
    // }

    // public Set<String> getJobListingStatus() {
    //     return jobListingStatus;
    // }

    // public void setJobListingStatus(Set<String> jobListingStatus) {
    //     this.jobListingStatus = jobListingStatus;
    // }

    // // Add these setter methods for status
    // public void setStudentStatus(String status) {
    //     this.studentStatus.add(status);
    // }

    // public void setJobListingStatus(String status) {
    //     this.jobListingStatus.add(status);
    // }

    // Additional methods, if needed...

    
}
