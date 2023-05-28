package com.api.applicationbackend.services;

import com.api.applicationbackend.model.Task;

import java.util.List;

public interface TaskService {

 List<Task> getTasks();
 Task createTask(Task task);
 Task getTask(Long id);
 Task updateTask(Task task);

}
