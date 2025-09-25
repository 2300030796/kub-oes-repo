package com.klef.sdp.repository;

import com.klef.sdp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	Teacher  findByEmailAndPassword(String email, String password);

}
