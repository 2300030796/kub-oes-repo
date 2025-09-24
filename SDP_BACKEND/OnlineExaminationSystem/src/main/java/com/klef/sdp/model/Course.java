package com.klef.sdp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_table")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String duration;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
}
