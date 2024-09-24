package org.example.table_objects;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectWorker {
    private long projectId;
    private long workerId;
}
