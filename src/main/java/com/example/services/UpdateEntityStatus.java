package com.example.services;


import com.example.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class UpdateEntityStatus {

    @Autowired
    private TaskServices service;


    @Async
    public void UpdateStatus(Task task){
        task.setTime(LocalDateTime.now());
        task.setStatus(Task.Status.RUNNING);
        service.update(task);
        try {
            TimeUnit.MINUTES.sleep(1);
            task = service.getById(task.getId()).get();
            System.out.println(task.toString());
            if(task != null){
            task.setTime(LocalDateTime.now());
            task.setStatus(Task.Status.FINISHED);
            service.update(task);}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
