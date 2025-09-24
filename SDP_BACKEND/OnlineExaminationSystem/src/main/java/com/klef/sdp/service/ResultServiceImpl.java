package com.klef.sdp.service;

import com.klef.sdp.model.Result;
import com.klef.sdp.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Result getResultById(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    @Override
    public List<Result> getResultsByStudent(Long studentId) {
        return resultRepository.findByStudentId(studentId);
    }

    @Override
    public List<Result> getResultsByExam(Long examId) {
        return resultRepository.findByExamId(examId);
    }
}
