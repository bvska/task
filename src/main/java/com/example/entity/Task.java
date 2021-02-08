package com.example.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

   // @Temporal(TemporalType.TIMESTAMP)
    @Column
    @org.hibernate.annotations.CreationTimestamp
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status = Status.CREATED;


    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public LocalTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status{
        CREATED, RUNNING, FINISHED
    }
}
