// src/components/HomePage.jsx
import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUserGraduate, faUsers } from '@fortawesome/free-solid-svg-icons';
import { Link } from 'react-router-dom';
import './HomeStyles.css';



const HomePage = () => {
  return (
    <div>
      <h1>Welcome to Job Board</h1>
      <Link to="/student">
        <FontAwesomeIcon icon={faUserGraduate} className="icon" />
        <span>Student</span>
      </Link>
      <Link to="/management">
        <FontAwesomeIcon icon={faUsers} className="icon" />
        <span>Management</span>
      </Link>
    </div>
  );
};

export default HomePage;
