// // AppliedStudents.jsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import './AppliedStudents.css';

const AppliedStudents = () => {
  const { jobListingid } = useParams();
  const [appliedStudents, setAppliedStudents] = useState([]);

  useEffect(() => {
    const fetchAppliedStudents = async () => {
      try {
        // Fetch applied students for the selected jobListingid
        const appliedStudentsResponse = await axios.get(
          `http://localhost:8080/api/applications/job/${jobListingid}`
        );

        setAppliedStudents(appliedStudentsResponse.data);
      } catch (error) {
        console.error('Error fetching applied students', error);
      }
    };

    fetchAppliedStudents();
  }, [jobListingid]);

  const handleUpdateStatus = async (applicationid, newStatus) => {
    try {
      // Update the student status in the database
      await axios.put(`http://localhost:8080/api/applications/status/${applicationid}`, null, {
        params: {
          newStatus: newStatus,
        },
      });

      // Update the local state to reflect the changes
      setAppliedStudents((prevStudents) =>
        prevStudents.map((student) =>
          student.applicationid === applicationid ? { ...student, studentstatus: newStatus } : student
        )
      );

      console.log(`Student status updated successfully: ${applicationid} - ${newStatus}`);
    } catch (error) {
      console.error('Error updating student status', error);
    }
  };

  return (
    <div>
      <h2>Applied Students for Job Listing ID: {jobListingid}</h2>
      <table border="1">
        <thead>
          <tr>
            <th>Name</th>
            <th>Registration Number</th>
            <th>School Name</th>
            <th>Grade Points</th>
            <th>College Name</th>
            <th>College Grade</th>
            <th>Number of Backlogs</th>
            <th>Preferred Languages</th>
            <th>Full Stack Experience</th>
            <th>Job Listing ID</th>
            <th>Applied Date</th>
            <th>Student Status</th>
            {/* Additional Columns */}
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {appliedStudents.map((student) => (
            <tr key={student.id}>
              <td>{student.name}</td>
              <td>{student.registrationNumber}</td>
              <td>{student.schoolName}</td>
              <td>{student.gradePoints}</td>
              <td>{student.collegeName}</td>
              <td>{student.collegeGrade}</td>
              <td>{student.numberOfBacklogs}</td>
              <td>{student.preferredLanguages}</td>
              <td>{student.fullStackExperience}</td>
              <td>{student.jobListingId}</td>
              <td>{student.appliedDate}</td>
              <td>{student.studentstatus}</td>
              {/* Additional Columns */}
              <td>
                <button onClick={() => handleUpdateStatus(student.applicationid, 'accepted')}>Accept</button>
                <button onClick={() => handleUpdateStatus(student.applicationid, 'rejected')}>Reject</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AppliedStudents;
