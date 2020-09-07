package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Set<Task> findAllByOrderByIdAsc();

    Set<Task> findByIfToDoIsTrue();

    Set<Task> findByIfToDoIsFalse();

    Set<Task> findByCategory(Category category);

    @Transactional
    Task save(Task task);



}
