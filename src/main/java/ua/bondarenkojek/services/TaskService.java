package ua.bondarenkojek.services;


import ua.bondarenkojek.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAllByUser_Id(Long id);

    void save(Task task);

    void deleteTask(Task task);

    void deleteTaskById(Long id);

    Task findById(Long id);
}
