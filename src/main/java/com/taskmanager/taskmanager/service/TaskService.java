package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.exception.RecordNotFoundException;
import com.taskmanager.taskmanager.model.TaskModel;
import com.taskmanager.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskModel create(TaskModel taskModel){
        return taskRepository.save(taskModel);
    }

    public List<TaskModel> findAll(){
        return taskRepository.findAll();
    }

    public void update(Long id, TaskModel taskModel){
        if (!taskRepository.findById(id).isEmpty()){
            taskModel.setId(id);
            taskRepository.save(taskModel);
        } else {
            throw new RecordNotFoundException(id);
        }
    }

    public void delete(Long id){
        taskRepository.delete(taskRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

    public TaskModel findById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }
}
