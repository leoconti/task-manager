package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.TaskModel;
import com.taskmanager.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void create(TaskModel taskModel){
        taskRepository.save(taskModel);
    }

    public List<TaskModel> findAll(){
        return taskRepository.findAll();
    }

    public void update(Long id, TaskModel taskModel){
        Optional<TaskModel> task = taskRepository.findById(id);

        if (!task.isEmpty()){
            taskModel.setId(id);
            taskRepository.save(taskModel);
        }
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}
