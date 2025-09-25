package com.klef.sdp.repository;

import com.klef.sdp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {
	Student  findByEmailAndPassword(String email, String password);
}
