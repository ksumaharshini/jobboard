package com.example.jobapplysystem.model;

public class AuthRequest {
    
    private String name;
    private String registrationNumber; // Applicable for students
    private String department; // Applicable for students
    private String password; // Applicable for management
    private String position; // Applicable for management
    private String userType; // This can be "student" or "management"

    public AuthRequest() {
    }

    // Constructor for student authentication
    public AuthRequest(String name, String registrationNumber, String department, String userType, String password, String position) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.department = department;
        this.userType = userType;
        this.password = password;
        this.position = position;
    }

    // Getters and setters...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "AuthRequest [name=" + name + ", registrationNumber=" + registrationNumber + ", department=" + department
                + ", password=" + password + ", position=" + position + ", userType=" + userType + "]";
    }
    
}
