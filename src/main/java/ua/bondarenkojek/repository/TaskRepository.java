package ua.bondarenkojek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.bondarenkojek.models.Task;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
        List<Task> findAllByUser_Id(Long id);
}
