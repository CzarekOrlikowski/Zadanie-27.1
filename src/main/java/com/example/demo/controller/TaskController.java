package com.example.demo.controller;

import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {

    public TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


}
