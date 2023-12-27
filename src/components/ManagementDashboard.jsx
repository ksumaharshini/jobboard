// ManagementDashboard.jsx
import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './ManagementDashboardStyles.css';

const ManagementDashboard = () => {
  const navigate = useNavigate();

  const handleAddJobListing = () => {
    navigate('/management/registration-form');
  };

  const handleViewJobListings = () => {
    navigate('/management/view/joblistings');
  };

  return (
    <div className="container">
      <h1>Management Dashboard</h1>
      <div>
        <button onClick={handleAddJobListing}>Add Job Listing</button>
        <button onClick={handleViewJobListings}>Show Job Listings</button>
      </div>
    </div>
  );
};

export default ManagementDashboard;
