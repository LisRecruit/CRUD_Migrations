package org.example.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;


@Data
@Builder
@Entity
@Table(name = "worker")
public class Worker {
    @Id
    private long id;
    private String name;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private WorkerLevel level;
    private int salary;
}
