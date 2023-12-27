// src/components/ManagementLoginPage.jsx
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './ManagementLoginStyles.css';

const ManagementLoginPage = () => {
  const [name, setName] = useState('');
  const [password, setPassword] = useState('');
  const [position, setPosition] = useState('');

  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const response = await axios.post('http://localhost:8080/api/verify/management', {
        name,
        password,
        position,
        userType: 'management',
      });

      if (response.data === 'Management authentication successful') {
        navigate('/management/dashboard');
      } else {
        console.error('Management authentication failed');
      }
    } catch (error) {
      console.error('Error during management authentication', error);
    }
  };

  return (
    <div className="container">
      <div>
        <h1>Management Verification</h1>
        <label>Name:</label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        <label>Password:</label>
        <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        <label>Position:</label>
        <input type="text" value={position} onChange={(e) => setPosition(e.target.value)} />
        <button onClick={handleLogin}>Login</button>
      </div>
    </div>
  );
};

export default ManagementLoginPage;
