package com.gos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class ServiceOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(unique = true)
    private String osNumber;
    
    @NotNull
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    @Enumerated(EnumType.STRING)
    private MaintenanceType type;
    
    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;
    
    @Size(max = 1000)
    private String serviceDescription;
    
    @PositiveOrZero
    private Integer downtime; // Em horas
    
    @PositiveOrZero
    private BigDecimal productionCost;
}