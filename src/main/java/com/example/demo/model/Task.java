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

    private boolean ifToDo;

    private String description;

    private java.sql.Date deadline;

    public Task() {
    }

    public Task(Long id, String name, Category category, boolean ifToDo, String description, Date deadline) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.ifToDo= ifToDo;
        this.description = description;
        this.deadline = deadline;
    }

    public Task(String name, Category category, boolean ifTodo, String description, Date deadline) {
        this (null, name, category, ifTodo, description, deadline);
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

    public boolean isIfToDo() {
        return ifToDo;
    }

    public void setIfToDo(boolean ifToDo) {
        this.ifToDo = ifToDo;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", ifToDo=" + ifToDo +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
