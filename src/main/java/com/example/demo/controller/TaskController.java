package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;


@Controller
public class TaskController {

    public TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping("/lista")
    public String getAll(Model model) {

        Set<Task> taskSet = taskRepository.findAllByOrderByIdAsc();
        model.addAttribute("taskSet", taskSet);

        return "lista";
    }

    @GetMapping("/ToDo")
    public String getAllToDo(Model model) {

        Set<Task> taskSet = taskRepository.findByIfToDoIsTrue();
        model.addAttribute("taskSet", taskSet);
        model.addAttribute("listName", "LISTA ZADAN DO WYKONANIA");

        return "zadania";
    }

    @GetMapping("/Done")
    public String getAllDone(Model model) {

        Set<Task> taskSet = taskRepository.findByIfToDoIsFalse();
        model.addAttribute("taskSet", taskSet);
        model.addAttribute("listName", "LISTA ZADAN WYKONANYCH (ARCHIWUM)");

        return "zadania";
    }

    @GetMapping("/kategoria")
    public String getUserForm1(Model model) {

        String attributeValue = null;
        model.addAttribute("category", attributeValue);

        return "kategoria";
    }

    @PostMapping("/category")
    public String getAllByCategory(Model model, @RequestParam String category) {

        Set<Task> taskSet = taskRepository.findByCategory(Category.valueOf(category));
        model.addAttribute("taskSet", taskSet);
        model.addAttribute("listName", "LISTA ZADAN W KATEGORII: " + Category.valueOf(category));

        return "zadania";
    }

    @GetMapping("/nowe")
    public String getUserForm2(Model model) {
        Task attributeValue = new Task();
        model.addAttribute("task", attributeValue);
        return "nowe";
    }

    @PostMapping("/add")
    public String add(Task task) {
        taskRepository.save(task);
        return "redirect:/lista";
    }

}