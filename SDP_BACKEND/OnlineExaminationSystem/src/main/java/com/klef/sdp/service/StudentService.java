package com.klef.sdp.service;

import com.klef.sdp.model.*;
import java.util.List;

public interface StudentService {
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    List<Exam> viewUpcomingExams();
    List<Exam> viewOngoingExamsForStudent(Long studentId);
    Result submitResult(Result result);
    List<Result> viewResultsByStudent(Long studentId);
}
