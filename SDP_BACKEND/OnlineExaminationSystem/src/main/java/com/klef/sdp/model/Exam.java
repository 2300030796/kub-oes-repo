package com.klef.sdp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exam_table")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    private LocalDateTime examDateTime;

    @Column(length = 20)
    private String duration;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDateTime getExamDateTime() { return examDateTime; }
    public void setExamDateTime(LocalDateTime examDateTime) { this.examDateTime = examDateTime; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
}
