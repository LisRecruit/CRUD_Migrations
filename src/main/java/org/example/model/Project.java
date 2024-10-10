package org.example.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
@Entity
@Table(name = "project")

public class Project {
    @Id
    private Long id;
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "finish_date")
    private LocalDate finishDate;
}
