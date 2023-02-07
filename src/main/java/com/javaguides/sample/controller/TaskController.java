package com.javaguides.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaguides.sample.exception.ResourceNotFoundException;
import com.javaguides.sample.model.Task;
import com.javaguides.sample.repository.TaskRepository;

@RestController
@RequestMapping("/tasks/")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("task")
    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    @GetMapping("/task/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long taskId )
			throws ResourceNotFoundException {
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + taskId));
		return ResponseEntity.ok().body(task);
	}

@PostMapping("task")
public Task createTask(@Valid @RequestBody Task task) {
    return taskRepository.save(task);
}


@PutMapping("/task/{id}")
public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long taskId,
        @Valid @RequestBody Task taskDetails) throws ResourceNotFoundException {
    Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + taskId));

    task.setTaskname(taskDetails.getTaskname());
    task.setTaskdesc(taskDetails.getTaskdesc());
    task.setStatus(taskDetails.getStatus());
    final Task updatedTask = taskRepository.save(task);
    return ResponseEntity.ok(updatedTask);
    }

        @DeleteMapping("/task/{id}")
        public Map<String,Boolean> deleteTask(@PathVariable(value = "id") Long taskId)
      
                throws ResourceNotFoundException {
            Task task = taskRepository.findById(taskId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + taskId));
    
            taskRepository.delete(task);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }
        
}