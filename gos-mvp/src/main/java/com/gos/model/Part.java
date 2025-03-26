package com.gos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String sequence;
    
    @ManyToOne
    @JoinColumn(name = "service_order_id")
    private ServiceOrder serviceOrder;
    
    private LocalDate date;
    
    @Enumerated(EnumType.STRING)
    private MaintenanceType type;
    
    private String partDescription;
    private Integer quantity;
    private BigDecimal unitValue;
    private BigDecimal totalValue;

    @PrePersist
    @PreUpdate
    private void calculateTotal() {
        this.totalValue = unitValue.multiply(BigDecimal.valueOf(quantity));
    }
}