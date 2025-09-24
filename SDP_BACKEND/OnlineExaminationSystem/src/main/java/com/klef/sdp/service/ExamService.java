package com.klef.sdp.service;

import com.klef.sdp.model.*;
import java.util.List;

public interface ExamService {
    Exam getExamById(Long id);
    List<Exam> getAllExams();
    void deleteExam(Long id);
}
