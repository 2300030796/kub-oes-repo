package com.klef.sdp.repository;

import com.klef.sdp.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
	 List<Exam> findByStartTimeAfter(LocalDateTime now); 
	    List<Exam> findByStartTimeBeforeAndEndTimeAfter(LocalDateTime start, LocalDateTime end);
}
