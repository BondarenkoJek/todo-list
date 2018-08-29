package ua.bondarenkojek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.bondarenkojek.models.Task;
import ua.bondarenkojek.repository.TaskRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAllByUser_Id(Long id) {
        return taskRepository.findAllByUser_Id(id);
    }


    @Override
    @Transactional
    public void save(Task task) {
        taskRepository.save(task);
    }


    @Override
    @Transactional
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }


    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }
}
