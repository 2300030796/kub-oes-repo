package com.klef.sdp.service;

import com.klef.sdp.model.*;
import com.klef.sdp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Exam scheduleExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public List<Exam> viewExams() {
        return examRepository.findAll();
    }

    @Override
    public List<Exam> viewUpcomingExams() {
        return examRepository.findByExamDateTimeAfter(LocalDateTime.now());
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> viewQuestionsByExam(Long examId) {
        return questionRepository.findByExamId(examId);
    }

    @Override
    public Result addResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public List<Result> viewResultsByExam(Long examId) {
        return resultRepository.findByExamId(examId);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> viewAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

	@Override
	public Teacher getlogin(Teacher t) {
		// TODO Auto-generated method stub
		return teacherRepository.findByEmailAndPassword(t.getEmail(), t.getPassword());
	}
}
