package com.klef.sdp.service;

import com.klef.sdp.model.*;
import com.klef.sdp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Optional<Course> opt = courseRepository.findById(id);
        if (opt.isPresent()) {
            Course c = opt.get();
            c.setName(course.getName());
            c.setDuration(course.getDuration());
            return courseRepository.save(c);
        }
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> viewCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Teacher> viewTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Student> viewStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Exam> viewExams() {
        return examRepository.findAll();
    }

    @Override
    public List<Result> viewResults() {
        return resultRepository.findAll();
    }
}
