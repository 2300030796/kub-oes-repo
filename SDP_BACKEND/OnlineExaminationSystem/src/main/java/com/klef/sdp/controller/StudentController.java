package com.klef.sdp.controller;

import com.klef.sdp.model.*;
import com.klef.sdp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/profile/{id}")
    public Student getProfile(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/profile")
    public Student updateProfile(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/exams/upcoming")
    public List<Exam> viewUpcomingExams() {
        return studentService.viewUpcomingExams();
    }

    @GetMapping("/exams/ongoing/{studentId}")
    public List<Exam> viewOngoingExams(@PathVariable Long studentId) {
        return studentService.viewOngoingExamsForStudent(studentId);
    }

    @PostMapping("/submit")
    public Result submitResult(@RequestBody Result result) {
        return studentService.submitResult(result);
    }

    @GetMapping("/results/{studentId}")
    public List<Result> viewResults(@PathVariable Long studentId) {
        return studentService.viewResultsByStudent(studentId);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Student loginRequest) {
        Student s = studentService.getlogin(loginRequest);

        if (s != null) {
            return ResponseEntity.ok(s);  // 200 OK with student object
        } else {
            return ResponseEntity.status(404)
                                 .body("Invalid email or password");  // 401
        }
    }
}
