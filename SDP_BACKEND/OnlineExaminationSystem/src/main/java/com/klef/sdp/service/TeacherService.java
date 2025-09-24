package com.klef.sdp.service;

import com.klef.sdp.model.*;
import java.util.List;

public interface TeacherService {
    Exam scheduleExam(Exam exam);
    List<Exam> viewExams();
    List<Exam> viewUpcomingExams();

    Question addQuestion(Question question);
    List<Question> viewQuestionsByExam(Long examId);

    Result addResult(Result result);
    List<Result> viewResultsByExam(Long examId);

    Student addStudent(Student student);
    List<Student> viewAllStudents();

    Teacher getTeacherById(Long id);
    Teacher updateTeacher(Teacher teacher);
}
