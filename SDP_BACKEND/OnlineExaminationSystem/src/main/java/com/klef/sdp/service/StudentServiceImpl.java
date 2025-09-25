package com.klef.sdp.service;

import com.klef.sdp.model.*;
import com.klef.sdp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Exam> viewUpcomingExams() {
        LocalDateTime now = LocalDateTime.now();
        return examRepository.findByStartTimeAfter(now);
    }

    @Override
    public List<Exam> viewOngoingExamsForStudent(Long studentId) {
        LocalDateTime now = LocalDateTime.now();
        return examRepository.findByStartTimeBeforeAndEndTimeAfter(now, now);
    }


    @Override
    public Result submitResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public List<Result> viewResultsByStudent(Long studentId) {
        return resultRepository.findByStudentId(studentId);
    }

	@Override
	public Student getlogin(Student s) {

		return studentRepository.findByEmailAndPassword(s.getEmail(),s.getPassword());
		 
	}
}
