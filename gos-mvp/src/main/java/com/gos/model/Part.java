@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sequence;
    @ManyToOne
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
    // Getters e Setters
}