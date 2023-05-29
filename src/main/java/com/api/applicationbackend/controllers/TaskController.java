package com.api.applicationbackend.controllers;

import com.api.applicationbackend.model.Task;
import com.api.applicationbackend.services.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@Validated @RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<Task>(createdTask, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @Validated @RequestBody Task task){
        Task updatedTask = taskService.updateTask(id, task);
        return new ResponseEntity<Task>(updatedTask, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getTasks();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable  long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        Task foundTask = taskService.getTask(id);
        return new ResponseEntity<Task>(foundTask, HttpStatus.OK);
    }

}
