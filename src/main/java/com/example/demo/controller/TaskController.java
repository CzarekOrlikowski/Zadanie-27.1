package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class TaskController {

    public TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    @ResponseBody
    public String getAll() {

        return taskRepository.findAllByOrderByIdAsc().stream()
                .map(Task::toString)
                .collect(Collectors.joining("<br>"));
    }
}