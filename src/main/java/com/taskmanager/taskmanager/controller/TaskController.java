package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.dto.TaskDto;
import com.taskmanager.taskmanager.model.TaskModel;
import com.taskmanager.taskmanager.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody TaskDto taskDto){
        taskService.create(mapper.map(taskDto, TaskModel.class));
    }

    @GetMapping
    ResponseEntity<List<TaskModel>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
    }

    @GetMapping("/{id}")
    TaskDto findById(@PathVariable(value = "id") Long id){
        return mapper.map(taskService.findById(id), TaskDto.class);
    }

    @PutMapping("/{id}")
    void update(@PathVariable(value = "id") Long id, @RequestBody TaskDto taskDto){taskService.update(id, mapper.map(taskDto, TaskModel.class));}

    @DeleteMapping("/{id}")
    void delete(@PathVariable(value = "id") Long id){taskService.delete(id);}
}
