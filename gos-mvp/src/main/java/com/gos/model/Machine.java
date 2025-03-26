package com.gos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Código é obrigatório")
    @Column(unique = true)
    private String code;
    
    @NotBlank(message = "Descrição é obrigatória")
    private String description;
    
    private String model;
    private String manufacturer;
    
    @Min(value = 1900, message = "Ano inválido")
    private Integer fabricationYear;
}