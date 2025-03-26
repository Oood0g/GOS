// Arquivo: src/main/java/com/gos/model/Labor.java
package com.gos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Labor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sequence;
    private String osNumber;
    private LocalDate date;
    
    @Enumerated(EnumType.STRING)
    private MaintenanceType type;
    
    @ManyToOne
    private Machine machine;
    
    private String technicianRole;
    private String technicianName;
    private Integer hoursWorked;
    private BigDecimal hourlyRate;
    private BigDecimal totalCost;

    @PrePersist
    @PreUpdate
    private void calculateTotal() {
        this.totalCost = hourlyRate.multiply(BigDecimal.valueOf(hoursWorked));
    }
}