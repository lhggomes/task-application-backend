package com.api.applicationbackend.services.impl;

import com.api.applicationbackend.model.Task;
import com.api.applicationbackend.repositories.TaskRepository;
import com.api.applicationbackend.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) return task.get();
        return null;
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Optional<Task> taskToUpdate = taskRepository.findById(id);
        if (taskToUpdate.isPresent()){

            taskToUpdate.get().setConcluido(task.getConcluido());
            taskToUpdate.get().setDetalhes(task.getDetalhes());
            taskToUpdate.get().setNome(task.getNome());

            taskRepository.save(taskToUpdate.get());

            return taskToUpdate.get();

        }
        return null;
    }
}
