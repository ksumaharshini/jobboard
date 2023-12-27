import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import StudentLoginPage from './components/StudentLoginPage';
import ManagementLoginPage from './components/ManagementLoginPage';
import HomePage from './components/HomePage';
import ManagementDashboard from './components/ManagementDashboard';
import JobListingRegistrationForm from './components/JobListingRegistrationForm';
import ApplyRegistrationForm from './components/ApplyRegistrationForm';
import ViewAppliedStudents from './components/ViewAppliedStudents';
import StudentJobListings from './components/StudentJobListings';
import AppliedStudents from './components/AppliedStudents';
import ViewJobListings from './components/ViewJobListings';


const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/student" element={<StudentLoginPage />} />
        <Route path="/management" element={<ManagementLoginPage />} />
        <Route path="/management/dashboard" element={<ManagementDashboard />} />
        <Route path="/management/registration-form" element={<JobListingRegistrationForm />} />
        <Route path="/student/joblistings/:department" element={<StudentJobListings />} />
        <Route
          path="/student/joblistings/:department/:jobListingid"
          element={<ApplyRegistrationForm />}
        />
        <Route
        path="/management/appliedstudents/:department/:jobListingid"
        element={<ViewAppliedStudents />}
        />
        <Route path="/management/view/joblistings" element={<ViewJobListings />} />
        <Route path="/management/appliedstudents/:jobListingid" element={<AppliedStudents />} />
      
      </Routes>
    </Router>
  );
};

export default App;
