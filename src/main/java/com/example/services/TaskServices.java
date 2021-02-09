package com.example.services;




import com.example.entity.Task;
import com.example.exception.TaskException;
import com.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServices {

    private TaskRepository repository;

    @Autowired
    public TaskServices(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskRepository getRepository() {
        return repository;
    }

    public Task add(Task task) {
        return repository.save(task);
    }

    public Optional<Task> getById(UUID id) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isEmpty()) throw new TaskException("Запись не существует");
        return optionalTask;
    }


    public void update(Task task){
        repository.save(task);
    }
}
