import React, { useState } from 'react';
import axios from 'axios';
import { Card, CardContent, Typography, TextField, Button, Grid, CircularProgress } from '@mui/material';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import config from '../config.js';

export default function ExamSchedule() {
  const [exam, setExam] = useState({
    name: '',
    date: '',
    startTime: '',
    endTime: '',
    duration: '',
    teacherName: '',
    subjectName: ''
  });

  const [loading, setLoading] = useState(false);

  const handleChange = (e) => {
    setExam({ ...exam, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setLoading(true);

    const startDateTime = `${exam.date}T${exam.startTime}`;
    const endDateTime = `${exam.date}T${exam.endTime}`;

    const payload = {
      name: exam.name,
      startTime: startDateTime,
      endTime: endDateTime,
      duration: exam.duration,
      teacherName: exam.teacherName,
      subjectName: exam.subjectName
    };

    axios.post(`${config.url}/teacher/exam`, payload)
      .then(() => {
        toast.success('Exam scheduled successfully!');
        setExam({
          name: '',
          date: '',
          startTime: '',
          endTime: '',
          duration: '',
          teacherName: '',
          subjectName: ''
        });
      })
      .catch(() => toast.error('Failed to schedule exam'))
      .finally(() => setLoading(false));
  };

  return (
    <div className="container mt-5">
      <ToastContainer />
      <Typography variant="h4" className="mb-4 text-center">Schedule Exam</Typography>

      <Card className="shadow-sm p-4">
        <CardContent>
          {loading ? (
            <div className="d-flex justify-content-center align-items-center" style={{ minHeight: '200px' }}>
              <CircularProgress />
            </div>
          ) : (
            <form onSubmit={handleSubmit}>
              <Grid container spacing={3}>
                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="Exam Name"
                    name="name"
                    value={exam.name}
                    onChange={handleChange}
                    required
                  />
                </Grid>

                <Grid item xs={12} sm={6}>
                  <TextField
                    fullWidth
                    label="Date"
                    type="date"
                    name="date"
                    value={exam.date}
                    onChange={handleChange}
                    InputLabelProps={{ shrink: true }}
                    required
                  />
                </Grid>

                <Grid item xs={12} sm={3}>
                  <TextField
                    fullWidth
                    label="Start Time"
                    type="time"
                    name="startTime"
                    value={exam.startTime}
                    onChange={handleChange}
                    InputLabelProps={{ shrink: true }}
                    required
                  />
                </Grid>

                <Grid item xs={12} sm={3}>
                  <TextField
                    fullWidth
                    label="End Time"
                    type="time"
                    name="endTime"
                    value={exam.endTime}
                    onChange={handleChange}
                    InputLabelProps={{ shrink: true }}
                    required
                  />
                </Grid>

                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="Duration (minutes)"
                    name="duration"
                    value={exam.duration}
                    onChange={handleChange}
                    placeholder="e.g., 120"
                    required
                  />
                </Grid>

                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="Teacher Name"
                    name="teacherName"
                    value={exam.teacherName}
                    onChange={handleChange}
                    required
                  />
                </Grid>

                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="Subject Name"
                    name="subjectName"
                    value={exam.subjectName}
                    onChange={handleChange}
                    required
                  />
                </Grid>

                <Grid item xs={12}>
                  <Button type="submit" variant="contained" color="primary" fullWidth>
                    Schedule Exam
                  </Button>
                </Grid>
              </Grid>
            </form>
          )}
        </CardContent>
      </Card>
    </div>
  );
}
