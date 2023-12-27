// ViewJobListings.jsx
import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './ViewJobListings.css';

const ViewJobListings = () => {
  const [jobListings, setJobListings] = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch job listings from the API
    axios.get('http://localhost:8080/api/joblistings/alljoblisting')
      .then(response => {
        setJobListings(response.data);
      })
      .catch(error => {
        console.error('Error fetching job listings:', error);
      });
  }, []);

  const handleShowAppliedStudents = (jobListingid) => {
    // Navigate to the AppliedStudents component with the jobListingid
    navigate(`/management/appliedstudents/${jobListingid}`);
  };

  const filteredJobListings = jobListings.filter(job =>
    job.title.toLowerCase().includes(searchQuery.toLowerCase())
  );

  return (
    <div className="container">
      <h2>Job Listings</h2>
      {/* Search Bar */}
      <input
        type="text"
        placeholder="Search by Title"
        value={searchQuery}
        onChange={(e) => setSearchQuery(e.target.value)}
      />
      <ul>
        {filteredJobListings.map(job => (
          <li key={job.jobListingid}>
            <strong>Job Listing ID:</strong> {job.jobListingid}<br />
            <strong>Title:</strong> {job.title}<br />
            <strong>Description:</strong> {job.description}<br />
            <button onClick={() => handleShowAppliedStudents(job.jobListingid)}>Show Applied Students</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ViewJobListings;
