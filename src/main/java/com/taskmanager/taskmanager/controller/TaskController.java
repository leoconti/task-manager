package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.dto.TaskDtoRequest;
import com.taskmanager.taskmanager.dto.TaskDtoResponse;
import com.taskmanager.taskmanager.model.TaskModel;
import com.taskmanager.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    ResponseEntity<TaskDtoResponse> create(@Valid @RequestBody TaskDtoRequest taskDtoRequest) {
        TaskDtoResponse result = mapper.map(
                taskService.create(mapper.map(taskDtoRequest, TaskModel.class)), TaskDtoResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    ResponseEntity<List<TaskDtoResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                taskService.findAll().stream()
                        .map(result -> mapper
                                .map(result, TaskDtoResponse.class)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskDtoResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.map(taskService.findById(id), TaskDtoResponse.class));
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> update(@PathVariable(value = "id") Long id, @Valid @RequestBody TaskDtoRequest taskDtoRequest) {
        taskService.update(id, mapper.map(taskDtoRequest, TaskModel.class));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
