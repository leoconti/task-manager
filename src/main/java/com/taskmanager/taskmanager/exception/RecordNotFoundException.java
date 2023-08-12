package com.taskmanager.taskmanager.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(Long id){
        super("Record not found id: " + id);
    }
}
