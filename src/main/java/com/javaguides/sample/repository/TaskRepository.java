package com.javaguides.sample.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaguides.sample.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}