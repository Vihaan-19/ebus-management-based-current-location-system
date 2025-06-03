package com.todo.todoapp.repositories;

import com.todo.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// jpa repostory -> interacts with the database
// entity <type, primary key>
public interface TaskRepository extends JpaRepository<Task,Long> {

}
