package org.example.tableObjects;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Worker {
    private long id;
    private String name;
    private Date birthday; // check var type. change to String?
    private WorkerLevel level;
    private int salary;
}
