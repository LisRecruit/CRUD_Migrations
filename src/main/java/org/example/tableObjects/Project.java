package org.example.tableObjects;
import java.time.LocalDate;
import java.util.Date;
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
