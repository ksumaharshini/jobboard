// JobListing.java
package com.example.jobapplysystem.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "joblisting")
public class JobListing {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long jobListingid;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "required_skills")
    private String requiredSkills;

    @Column(name = "location")
    private String location;

    @Column(name = "salary_package")
    private double salaryPackage;

    @Column(name = "bond_period_months")
    private int bondPeriodMonths;
    private String jobListingStatus;

    // Directly include department information in the JobListing entity
    @ElementCollection
    @CollectionTable(name = "joblisting_departments", joinColumns = @JoinColumn(name = "joblisting_id"))
    @Column(name = "department")
    private Set<String> departments = new HashSet<>();

    // existing constructors, getters, setters...

    
    public JobListing() {
        super();
        this.jobListingStatus = "In Progress";
    }

    public JobListing(Long jobListingid, String title, String description, Date deadline, String requiredSkills,
            String location, double salaryPackage, int bondPeriodMonths, String jobListingStatus,
            Set<String> departments) {
        this.jobListingid = jobListingid;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.requiredSkills = requiredSkills;
        this.location = location;
        this.salaryPackage = salaryPackage;
        this.bondPeriodMonths = bondPeriodMonths;
        this.jobListingStatus = jobListingStatus;
        this.departments = departments;
    }

    public Long getJobListingid() {
        return jobListingid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public String getLocation() {
        return location;
    }

    public double getSalaryPackage() {
        return salaryPackage;
    }

    public int getBondPeriodMonths() {
        return bondPeriodMonths;
    }

    public String getJobListingStatus() {
        return jobListingStatus;
    }

    public Set<String> getDepartments() {
        return departments;
    }

    public void setJobListingid(Long jobListingid) {
        this.jobListingid = jobListingid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSalaryPackage(double salaryPackage) {
        this.salaryPackage = salaryPackage;
    }

    public void setBondPeriodMonths(int bondPeriodMonths) {
        this.bondPeriodMonths = bondPeriodMonths;
    }

    public void setJobListingStatus(String jobListingStatus) {
        this.jobListingStatus = jobListingStatus;
    }

    public void setDepartments(Set<String> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "JobListing [jobListingid=" + jobListingid + ", title=" + title + ", description=" + description
                + ", deadline=" + deadline + ", requiredSkills=" + requiredSkills + ", location=" + location
                + ", salaryPackage=" + salaryPackage + ", bondPeriodMonths=" + bondPeriodMonths + ", jobListingStatus="
                + jobListingStatus + ", departments=" + departments + "]";
    }


    
    
    
}

    // Constructors, getters, and setters...
    

    // Additional methods, if needed...
