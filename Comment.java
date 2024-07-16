package com.commentprojectexample.pertsolproject.model;

import jakarta.persistence.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
// Annotations to specify that id is the primary key and auto-generated.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String by;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDateTime dateofcomment;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateofcomment() {
        return dateofcomment;
    }

    public void setDateofcomment(LocalDateTime dateofcomment) {
        this.dateofcomment = dateofcomment;
    }
}
