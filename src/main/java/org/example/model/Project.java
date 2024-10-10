package org.example.table_objects;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class Project {
    private Long id;
    private Long clientId;
    private LocalDate startDate;
    private LocalDate finishDate;
}
