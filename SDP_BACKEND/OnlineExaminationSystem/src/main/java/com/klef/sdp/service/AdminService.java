package com.klef.sdp.service;

import com.klef.sdp.model.*;
import java.util.List;

public interface AdminService {
    Admin getAdminByUsername(String username);

    Course addCourse(Course course);
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
    List<Course> viewCourses();

    Teacher addTeacher(Teacher teacher);
    void deleteTeacher(Long id);
    List<Teacher> viewTeachers();

    List<Student> viewStudents();
    void deleteStudent(Long id);

    List<Exam> viewExams();

    List<Result> viewResults();
}
