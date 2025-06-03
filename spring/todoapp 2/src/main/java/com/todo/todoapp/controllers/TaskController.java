package com.todo.todoapp.controllers;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model)
    {
        List<Task> tasks=taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title)
    {
        taskService.createTask(title);
        return "tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTaskById(@PathVariable Long id)
    {
        taskService.deleteTask(id);

        return "tasks";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id)
    {
        taskService.toggleTask(id);

        return "tasks";
    }
}
