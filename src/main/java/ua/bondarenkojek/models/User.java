package ua.bondarenkojek.models;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String userName;

    @NonNull
    private String password;

    @NonNull
    private String email;



    @OneToMany
    private List<Task> taskList = new ArrayList<>();

//    public void addTask(Task task) {
//        task.setUser(this);
//        getTaskList().add(task);
//    }
//
//    public void removeTask(Task task) {
//        getTaskList().remove(task);
//    }
}
