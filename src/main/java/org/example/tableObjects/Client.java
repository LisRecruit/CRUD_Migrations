package org.example.tableObjects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    public Long id;
    public String name;
}

