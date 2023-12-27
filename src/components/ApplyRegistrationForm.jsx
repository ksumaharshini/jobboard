// ApplyRegistrationForm.jsx
import React, { useState } from 'react';
import axios from 'axios';
import './ApplyRegistrationForm.css';
import { useParams } from 'react-router-dom';

const ApplyRegistrationForm = () => {
  // State variables to store form data
  const {jobListingId: initialJobListingId } = useParams();
  const [department, setDepartment] = useState('');
  const [name, setName] = useState('');
  const [registrationNumber, setRegistrationNumber] = useState('');
  const [jobListingId, setJobListingId] = useState(initialJobListingId); // Initialize with the value from URL

  const [schoolName, setSchoolName] = useState('');
  const [gradePoints, setGradePoints] = useState('');
  const [collegeName, setCollegeName] = useState('');
  const [collegeGrade, setCollegeGrade] = useState('');
  const [numberOfBacklogs, setNumberOfBacklogs] = useState('');
  const [preferredLanguages, setPreferredLanguages] = useState('');
  const [fullStackExperience, setFullStackExperience] = useState('');
  const [appliedDate] = useState(new Date()); // Assuming appliedDate is not user-input

  // Function to handle form submission
  const handleApply = async () => {
    try {
      // Prepare the data to be sent in the request
      const requestData = {
        appliedDate,
        name,
        registrationNumber,
        schoolName,
        gradePoints,
        collegeName,
        collegeGrade,
        numberOfBacklogs,
        preferredLanguages: preferredLanguages.split(',').map(lang => lang.trim()),
        fullStackExperience,
        jobListingId,
        studentRegistrationNumber: registrationNumber,
      };

      // Send a POST request to submit the application
      const response = await axios.post(`http://localhost:8080/api/applications/apply`, requestData);

      // Log success message and response data
      console.log('Application submitted successfully', response.data);
    } catch (error) {
      // Log error if the submission fails
      console.error('Error submitting application', error);
    }
  };

  // JSX rendering
  return (
    <div className="registration-form">
      <label>Job Listing ID:</label>
  <input
    type="text"
    value={jobListingId}
    onChange={(e) => setJobListingId(e.target.value)}
  />
      <div>
        <label>Name:</label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
      </div>
      <div>
        <label>Registration Number:</label>
        <input type="text" value={registrationNumber} onChange={(e) => setRegistrationNumber(e.target.value)} />
      </div>
      <div>
        <label>School Name:</label>
        <input type="text" value={schoolName} onChange={(e) => setSchoolName(e.target.value)} />
      </div>
      <div>
        <label>Grade Points:</label>
        <input type="text" value={gradePoints} onChange={(e) => setGradePoints(e.target.value)} />
      </div>
      <div>
        <label>College Name:</label>
        <input type="text" value={collegeName} onChange={(e) => setCollegeName(e.target.value)} />
      </div>
      <div>
        <label>College Grade:</label>
        <input type="text" value={collegeGrade} onChange={(e) => setCollegeGrade(e.target.value)} />
      </div>
      <div>
        <label>Number of Backlogs:</label>
        <input type="text" value={numberOfBacklogs} onChange={(e) => setNumberOfBacklogs(e.target.value)} />
      </div>
      <div>
        <label>Preferred Languages (comma-separated):</label>
        <input
          type="text"
          value={preferredLanguages}
          onChange={(e) => setPreferredLanguages(e.target.value)}
        />
      </div>
      <div>
        <label>Full Stack Experience:</label>
        <input
          type="text"
          value={fullStackExperience}
          onChange={(e) => setFullStackExperience(e.target.value)}
        />
      </div>
      <div>
        <label>Job Listing ID:</label>
        <input
          type="text"
          value={jobListingId}
          onChange={(e) => setJobListingId(e.target.value)}
        />
      </div>
      <button onClick={handleApply}>Submit Application</button>
    </div>
  );
};

export default ApplyRegistrationForm;
