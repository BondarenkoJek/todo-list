package ua.bondarenkojek.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tasklists")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @NonNull
    private String taskDescription;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean state;

    @ManyToOne
    private User user;

}
