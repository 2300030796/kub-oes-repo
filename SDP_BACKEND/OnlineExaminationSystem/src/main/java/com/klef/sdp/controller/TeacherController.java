package com.klef.sdp.controller;

import com.klef.sdp.model.*;
import com.klef.sdp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/exam")
    public Exam scheduleExam(@RequestBody Exam exam) {
        return teacherService.scheduleExam(exam);
    }

    @GetMapping("/exams")
    public List<Exam> viewExams() {
        return teacherService.viewExams();
    }

    @GetMapping("/exams/upcoming")
    public List<Exam> upcomingExams() {
        return teacherService.viewUpcomingExams();
    }

    @PostMapping("/question")
    public Question addQuestion(@RequestBody Question question) {
        return teacherService.addQuestion(question);
    }

    @GetMapping("/questions/{examId}")
    public List<Question> viewQuestions(@PathVariable Long examId) {
        return teacherService.viewQuestionsByExam(examId);
    }

    @PostMapping("/result")
    public Result addResult(@RequestBody Result result) {
        return teacherService.addResult(result);
    }

    @GetMapping("/results/{examId}")
    public List<Result> viewResultsByExam(@PathVariable Long examId) {
        return teacherService.viewResultsByExam(examId);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return teacherService.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> viewStudents() {
        return teacherService.viewAllStudents();
    }

    @GetMapping("/profile/{id}")
    public Teacher getProfile(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/profile")
    public Teacher updateProfile(@RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacher);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginTeacher(@RequestBody Teacher teacher) {
        Teacher t = teacherService.getlogin(teacher);

        if (t != null) {
            return ResponseEntity.ok(t);
        } else {  
            return ResponseEntity.status(404)
                                 .body("Invalid email or password");
        }
    }
    
}
