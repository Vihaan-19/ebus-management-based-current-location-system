package com.todo.todoapp.services;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        List<Task> allTasks=taskRepository.findAll();
        return allTasks;
    }

    public void createTask(String title) {
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task=taskRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid task"));
        task.setCompleted(!task.getCompleted());

        taskRepository.save(task);
    }
}
