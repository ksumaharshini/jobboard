// import React, { useState, useEffect } from 'react';
// import axios from 'axios';
// import { useParams } from 'react-router-dom';

// const ViewAppliedStudents = () => {
//   const { department, jobListingid } = useParams();
//   const [appliedStudents, setAppliedStudents] = useState([]);

//   useEffect(() => {
//     const fetchAppliedStudents = async () => {
//       try {
//         // Fetch all job listing IDs for the department
//         const jobIdsUrl = http://localhost:8080/api/joblistings/joblistingid/bydepartment/${department};
//         const jobListingIdsResponse = await axios.get(jobIdsUrl);

//         // Use the provided jobListingid or the first ID from the list
//         const selectedJobListingId = jobListingid || jobListingIdsResponse.data[0];

//         // Fetch applied students for the selected jobListingid
//         const appliedStudentsResponse = await axios.get(
//           http://localhost:8080/api/applications/job/${selectedJobListingId}
//         );

//         setAppliedStudents(appliedStudentsResponse.data);
//       } catch (error) {
//         console.error('Error fetching applied students', error);
//       }
//     };

//     fetchAppliedStudents();
//   }, [department, jobListingid]);

//   return (
//     <div>
//       <h2>Applied Students for {department}</h2>
//       <table border="1">
//         <thead>
//           <tr>
//             <th>Student ID</th>
//             <th>Name</th>
//             <th>Registration Number</th>
//           </tr>
//         </thead>
//         <tbody>
//           {appliedStudents.map((student) => (
//             <tr key={student.studentId}>
//               <td>{student.studentId}</td>
//               <td>{student.name}</td>
//               <td>{student.registrationNumber}</td>
//             </tr>
//           ))}
//         </tbody>
//       </table>
//     </div>
//   );
// };

// export default ViewAppliedStudents;
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import './ViewAppliedStudents.css';

const ViewAppliedStudents = () => {
  const { department, jobListingid } = useParams();
  const [appliedStudents, setAppliedStudents] = useState([]);

  useEffect(() => {
    const fetchAppliedStudents = async () => {
      try {
        // Fetch all job listing IDs for the department
        const jobIdsUrl = `http://localhost:8080/api/joblistings/joblistingid/bydepartment/${department}`;
        const jobListingIdsResponse = await axios.get(jobIdsUrl);

        // Use the provided jobListingid or the first ID from the list
        const selectedJobListingId = jobListingid || jobListingIdsResponse.data[0];

        // Fetch applied students for the selected jobListingid
        const appliedStudentsResponse = await axios.get(
          `http://localhost:8080/api/applications/job/${selectedJobListingId}`
        );

        setAppliedStudents(appliedStudentsResponse.data);
      } catch (error) {
        console.error('Error fetching applied students', error);
      }
    };

    fetchAppliedStudents();
  }, [department, jobListingid]);

  return (
    <div>
      <h2>Applied Students for {department}</h2>
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
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ViewAppliedStudents;