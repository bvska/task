package com.example.controllers;


import com.example.entity.Task;
import com.example.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;



@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskServices service;

    @GetMapping("/{id}")
    public Task getById(@PathVariable UUID id) {
        Optional<Task> optionalTask;
        try {
            optionalTask = service.getById(id);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return optionalTask.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UUID addTask(@RequestBody Task task) {
        service.add(task);
        task.setTime(LocalDateTime.now());
        task.setStatus(Task.Status.RUNNING);
        service.update(task);

        return task.getId();
    }
}
