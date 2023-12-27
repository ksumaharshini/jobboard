// src/components/JobListingRegistrationForm.jsx
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './JobListingRegistrationFormStyles.css';

const JobListingRegistrationForm = () => {
  const [formData, setFormData] = useState({
    title: '',
    description: '',
    deadline: '',
    requiredSkills: '',
    location: '',
    salaryPackage: 0.0,
    bondPeriodMonths: 0,
    departments: [],
  });

  const navigate = useNavigate();

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/joblistings/addjoblisting', formData);
      // Redirect to the management dashboard after successful submission
      navigate('/management/dashboard');
    } catch (error) {
      console.error('Error during job listing submission', error);
    }
  };

  return (
    <div className="container">
      <h1>Job Listing Registration Form</h1>
      <form onSubmit={handleSubmit}>
        <label>Title:</label>
        <input type="text" name="title" value={formData.title} onChange={handleInputChange} />

        <label>Description:</label>
        <textarea name="description" value={formData.description} onChange={handleInputChange} />

        <label>Deadline:</label>
        <input type="date" name="deadline" value={formData.deadline} onChange={handleInputChange} />

        <label>Required Skills:</label>
        <input type="text" name="requiredSkills" value={formData.requiredSkills} onChange={handleInputChange} />

        <label>Location:</label>
        <input type="text" name="location" value={formData.location} onChange={handleInputChange} />

        <label>Salary Package:</label>
        <input type="number" name="salaryPackage" value={formData.salaryPackage} onChange={handleInputChange} />

        <label>Bond Period (Months):</label>
        <input type="number" name="bondPeriodMonths" value={formData.bondPeriodMonths} onChange={handleInputChange} />

        {/* Assuming departments is an array of strings */}
        <label>Departments:</label>
<input
  type="text"
  name="departments"
  value={formData.departments.join(',')}
  onChange={(e) => {
    const departmentsArray = e.target.value.split(',');
    setFormData({
      ...formData,
      departments: departmentsArray,
    });
  }}
/>

        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default JobListingRegistrationForm;
