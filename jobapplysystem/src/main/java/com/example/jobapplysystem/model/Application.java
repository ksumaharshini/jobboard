// Application.java
package com.example.jobapplysystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicationId;

    @Column(name = "status")
    private String studentstatus;

    @Column(name = "applied_date")
    private Date appliedDate;

    @Column(name = "name")
    private String name;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "grade_points")
    private double gradePoints;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "college_grade")
    private String collegeGrade;

    @Column(name = "number_of_backlogs")
    private int numberOfBacklogs;

    @ElementCollection
    @CollectionTable(name = "application_languages", joinColumns = @JoinColumn(name = "application_id"))
    @Column(name = "language")
    private Set<String> preferredLanguages = new HashSet<>();

    @Column(name = "full_stack_experience")
    private String fullStackExperience;

    @Column(name = "joblisting_id")
    private long jobListingId;

    @Column(name = "student_registration_number")
    private String studentRegistrationNumber;

    // Constructors, getters, and setters...
    public Application() {
        super();
        this.studentstatus = "Received";
        this.preferredLanguages = new HashSet<>();
    }

    // Other constructors, getters, and setters...

    // Additional code...

    // Ensure that empty values are excluded during serialization
    

    public Application(Long applicationid, String studentstatus, Date appliedDate, String name,
            String registrationNumber, String schoolName, double gradePoints, String collegeName, String collegeGrade,
            int numberOfBacklogs, Set<String> preferredLanguages, String fullStackExperience, long jobListingId,
            String studentRegistrationNumber) {
                applicationId = applicationid;
        this.studentstatus = studentstatus;
        this.appliedDate = appliedDate;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.schoolName = schoolName;
        this.gradePoints = gradePoints;
        this.collegeName = collegeName;
        this.collegeGrade = collegeGrade;
        this.numberOfBacklogs = numberOfBacklogs;
        this.preferredLanguages = preferredLanguages;
        this.fullStackExperience = fullStackExperience;
        this.jobListingId = jobListingId;
        this.studentRegistrationNumber = studentRegistrationNumber;
    }

    public void setApplicationid(Long applicationid) {
        applicationId = applicationid;
    }

    public void setStudentstatus(String studentstatus) {
        this.studentstatus = studentstatus;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setGradePoints(double gradePoints) {
        this.gradePoints = gradePoints;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setCollegeGrade(String collegeGrade) {
        this.collegeGrade = collegeGrade;
    }

    public void setNumberOfBacklogs(int numberOfBacklogs) {
        this.numberOfBacklogs = numberOfBacklogs;
    }

    public void setFullStackExperience(String fullStackExperience) {
        this.fullStackExperience = fullStackExperience;
    }

    public void setJobListingId(long jobListingId) {
        this.jobListingId = jobListingId;
    }

    public void setStudentRegistrationNumber(String studentRegistrationNumber) {
        this.studentRegistrationNumber = studentRegistrationNumber;
    }

    public Long getApplicationid() {
        return applicationId;
    }

    public String getStudentstatus() {
        return studentstatus;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public double getGradePoints() {
        return gradePoints;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getCollegeGrade() {
        return collegeGrade;
    }

    public int getNumberOfBacklogs() {
        return numberOfBacklogs;
    }

    public String getFullStackExperience() {
        return fullStackExperience;
    }

    public long getJobListingId() {
        return jobListingId;
    }

    public String getStudentRegistrationNumber() {
        return studentRegistrationNumber;
    }

    public void setPreferredLanguages(Set<String> preferredLanguages) {
        this.preferredLanguages = preferredLanguages;
    }
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Set<String> getPreferredLanguages() {
        return preferredLanguages;
    }

    @Override
    public String toString() {
        return "Application [Applicationid=" + applicationId + ", studentstatus=" + studentstatus + ", appliedDate="
                + appliedDate + ", name=" + name + ", registrationNumber=" + registrationNumber + ", schoolName="
                + schoolName + ", gradePoints=" + gradePoints + ", collegeName=" + collegeName + ", collegeGrade="
                + collegeGrade + ", numberOfBacklogs=" + numberOfBacklogs + ", preferredLanguages=" + preferredLanguages
                + ", fullStackExperience=" + fullStackExperience + ", jobListingId=" + jobListingId
                + ", studentRegistrationNumber=" + studentRegistrationNumber + "]";
    }
    
}
