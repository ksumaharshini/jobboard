// Import necessary dependencies from React and React Router
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';  // Import Axios for making HTTP requests
import './StudentLoginPage.css';  // Import styles for the component

// Define the functional component named StudentLoginPage
const StudentLoginPage = () => {
  // Define state variables using the useState hook
  const [name, setName] = useState('');  // State for the student's name
  const [registrationNumber, setRegistrationNumber] = useState('');  // State for the student's registration number
  const [department, setDepartment] = useState('');  // State for the student's department

  // Use the useNavigate hook to get the navigate function
  const navigate = useNavigate();

  // Define a function to handle the login process when the user clicks the "Submit" button
  const handleLogin = async () => {
    try {
      // Make a POST request to the server to verify student authentication
      const response = await axios.post('http://localhost:8080/api/verify/student', {
        name,  // Include the student's name in the request
        registrationNumber,  // Include the student's registration number in the request
        department,  // Include the student's department in the request
        userType: 'student',  // Include the user type as 'student' in the request
      });

      // Check if the authentication was successful
      if (response.data === 'Student authentication successful') {
        // Redirect to the job listings page if authentication is successful
        navigate(`/student/joblistings/${department}`);
      } else {
        // Log an error message if authentication fails
        console.error('Student authentication failed');
      }
    } catch (error) {
      // Log an error if there is an issue with the authentication process
      console.error('Error during student authentication', error);
    }
  };

  // JSX rendering for the component
  return (
    <div>
      <h1>Student Verification</h1>
      {/* Input field for the student's name */}
      <label>Name:</label>
      <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
      
      {/* Input field for the student's registration number */}
      <label>Registration Number:</label>
      <input type="text" value={registrationNumber} onChange={(e) => setRegistrationNumber(e.target.value)} />
      
      {/* Input field for the student's department */}
      <label>Department:</label>
      <input type="text" value={department} onChange={(e) => setDepartment(e.target.value)} />
      
      {/* Button to trigger the login process */}
      <button onClick={handleLogin}>Submit</button>
    </div>
  );
};

// Export the StudentLoginPage component as the default export
export default StudentLoginPage;
