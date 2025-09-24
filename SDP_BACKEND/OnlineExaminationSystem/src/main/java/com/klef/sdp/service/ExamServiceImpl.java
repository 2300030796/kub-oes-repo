package com.klef.sdp.service;

import com.klef.sdp.model.Exam;
import com.klef.sdp.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam getExamById(Long id) {
        return examRepository.findById(id).orElse(null);
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
