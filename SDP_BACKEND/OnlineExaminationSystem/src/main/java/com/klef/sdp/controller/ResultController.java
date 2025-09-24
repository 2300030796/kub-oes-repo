package com.klef.sdp.controller;

import com.klef.sdp.model.Result;
import com.klef.sdp.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/student/{studentId}")
    public List<Result> getByStudent(@PathVariable Long studentId) {
        return resultService.getResultsByStudent(studentId);
    }

    @GetMapping("/exam/{examId}")
    public List<Result> getByExam(@PathVariable Long examId) {
        return resultService.getResultsByExam(examId);
    }

    @GetMapping("/{id}")
    public Result getResult(@PathVariable Long id) {
        return resultService.getResultById(id);
    }
}
