package com.example.diabloivforum.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String text;

    @Column
    private ZonedDateTime created;

    @ManyToOne
    private Problem problem;

    public Comment() {

    }

    public Comment(Long id, String text, ZonedDateTime created) {
        this.id = id;
        this.text = text;
        this.created = created;
        this.created = ZonedDateTime.now(ZoneId.of("UTC"));
    }


    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
