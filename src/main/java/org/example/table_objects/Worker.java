package org.example.table_objects;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class Worker {
    private long id;
    private String name;
    private LocalDate birthday;
    private WorkerLevel level;
    private int salary;
}
