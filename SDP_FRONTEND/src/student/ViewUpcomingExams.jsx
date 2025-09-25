import React, { useState, useEffect } from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  CircularProgress,
  Typography,
} from "@mui/material";
import axios from "axios";
import config from "../config";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function ViewUpcomingExams() {
  const [exams, setExams] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios
      .get(`${config.url}/student/exams/upcoming`)
      .then((res) => {
        setExams(res.data);
        setLoading(false);
      })
      .catch(() => {
        toast.error("Failed to fetch upcoming exams");
        setLoading(false);
      });
  }, []);

  if (loading) {
    return (
      <div
        className="d-flex justify-content-center align-items-center"
        style={{ minHeight: "70vh" }}
      >
        <CircularProgress />
      </div>
    );
  }

  return (
    <div className="container mt-5">
      <ToastContainer />
      <Typography variant="h4" className="mb-4 text-center">
        Upcoming Exams
      </Typography>

      <TableContainer component={Paper} className="shadow-sm">
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Exam Name</TableCell>
              <TableCell>Subject Name</TableCell>
              <TableCell>Teacher Name</TableCell>
              <TableCell>Start Time</TableCell>
              <TableCell>End Time</TableCell>
              <TableCell>Duration (minutes)</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {exams.length === 0 ? (
              <TableRow>
                <TableCell colSpan={6} align="center">
                  No upcoming exams
                </TableCell>
              </TableRow>
            ) : (
              exams.map((exam) => (
                <TableRow key={exam.id}>
                  <TableCell>{exam.name}</TableCell>
                  <TableCell>{exam.subjectName}</TableCell>
                  <TableCell>{exam.teacherName}</TableCell>
                  <TableCell>
                    {new Date(exam.startTime).toLocaleString()}
                  </TableCell>
                  <TableCell>
                    {new Date(exam.endTime).toLocaleString()}
                  </TableCell>
                  <TableCell>{exam.duration}</TableCell>
                </TableRow>
              ))
            )}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
}

export default ViewUpcomingExams;
