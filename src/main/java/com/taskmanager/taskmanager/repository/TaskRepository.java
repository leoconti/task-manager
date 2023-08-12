package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {

}
