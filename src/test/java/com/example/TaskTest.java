package com.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class TaskTest {


    @Test
    void getStatusNewTask() {
        Task task = new Task();
        task.setTimestamp(LocalDateTime.now());
        Assert.assertEquals("Bad", task.getStatus(), Task.Status.CREATED );
    }

}