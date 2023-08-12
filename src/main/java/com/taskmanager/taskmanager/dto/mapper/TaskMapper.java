package com.taskmanager.taskmanager.dto.mapper;

import com.taskmanager.taskmanager.dto.TaskDto;
import com.taskmanager.taskmanager.model.TaskModel;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskModel taskDtoToTaskModel(TaskDto taskDto){
        TaskModel taskModel = new TaskModel();
        taskModel.setTitle(taskDto.getTitle());
        taskModel.setDescription(taskDto.getDescription());
        taskModel.setDone(taskDto.getDone());
        taskModel.setPriority(taskDto.getPriority());

        return taskModel;
    }

}
