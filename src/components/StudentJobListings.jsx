// StudentJobListings.jsx
import React, { useState, useEffect } from 'react';
import { useParams, Link, Routes, Route } from 'react-router-dom';
import axios from 'axios';
import ApplyRegistrationForm from './ApplyRegistrationForm';
import ViewAppliedStudents from './ViewAppliedStudents';
import './StudentJobListingsStyles.css'; // Import the CSS file

const StudentJobListings = () => {
  const { department } = useParams();
  const [jobListings, setJobListings] = useState([]);

  useEffect(() => {
    const fetchJobListings = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/joblistings/bydepartment/${department}`);
        setJobListings(response.data);
      } catch (error) {
        console.error('Error fetching job listings', error);
      }
    };

    fetchJobListings();
  }, [department]);

  return (
    <div className="job-listings-container">
      <h1 className="header">Job Listings for {department}</h1>
      <ul className="job-list">
        {jobListings.map((jobListing) => (
          <li key={jobListing.jobListingid} className="job-item">
            <div className="left-section">
              <p>Job Listing ID: {jobListing.jobListingid}</p>
              <p>Title: {jobListing.title}</p>
              <p>Description: {jobListing.description}</p>
              <p>Deadline: {jobListing.deadline}</p>
              <p>Required Skills: {jobListing.requiredSkills}</p>
              <p>Location: {jobListing.location}</p>
              <p>Salary Package: {jobListing.salaryPackage}</p>
              <p>Bond Period (Months): {jobListing.bondPeriodMonths}</p>
              <p>Departments: {jobListing.departments.join(', ')}</p>
            </div>
            <div className="right-section">
              <Link to={`/student/joblistings/${department}/${jobListing.jobListingid}`}>
                <button className="apply-button">Apply</button>
              </Link>
              <Link to={`/management/appliedstudents/${department}/${jobListing.jobListingid}`}>
                <button className="view-button">View Applied Students</button>
              </Link>
            </div>
          </li>
        ))}
      </ul>

      <Routes>
        <Route
          path="/student/joblistings/:department/:jobListingid"
          element={<ApplyRegistrationForm />}
        />
        <Route
          path="/management/appliedstudents/:department/:jobListingid"
          element={<ViewAppliedStudents />}
        />
      </Routes>
    </div>
  );
};

export default StudentJobListings;
