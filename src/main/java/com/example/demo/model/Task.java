package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType. STRING)
    private Category category;

    private boolean realisation;

    private String description;

    private java.sql.Date deadline;

    public Task() {
    }

    public Task(Long id, String name, Category category, boolean realisation, String description, Date deadline) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.realisation = realisation;
        this.description = description;
        this.deadline = deadline;
    }

    public Task(String name, Category category, boolean realisation, String description, Date deadline) {
        this (null, name, category, realisation, description, deadline);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isRealisation() {
        return realisation;
    }

    public void setRealisation(boolean realisation) {
        this.realisation = realisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
