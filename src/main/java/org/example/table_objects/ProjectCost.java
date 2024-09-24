package org.example.table_objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectCost {
    private long projectId;
    private long clientId;
    private double cost;
}
