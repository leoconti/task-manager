package com.taskmanager.taskmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean done;
    private int priority;

    public TaskModel(Long id, String title, String description, Boolean done, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.priority = priority;
    }

    public TaskModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
