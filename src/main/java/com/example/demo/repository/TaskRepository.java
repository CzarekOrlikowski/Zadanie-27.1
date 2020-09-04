package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.List;
import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Set<Task> findAllByOrderByIdAsc();
    Set<Task> findTaskByRealisation(boolean realisation);
    Set<Task> findAllByOrderByDeadlineAsc ();
    Set<Task> findTaskByCategory(Category category);

}
