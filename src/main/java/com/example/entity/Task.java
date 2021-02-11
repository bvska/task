package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Task {
    /**
     * @param Id первичный ключ
     * @param time - время создания/измененения задачи
     * @param status - состояние задачи
     **/

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column
    @org.hibernate.annotations.CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status = Status.CREATED;



    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        if (!(time instanceof LocalDateTime))
            throw new IllegalArgumentException ("объект не является датой");
        this.time = time;

    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }


    public enum Status {
        CREATED, RUNNING, FINISHED
    }
}
