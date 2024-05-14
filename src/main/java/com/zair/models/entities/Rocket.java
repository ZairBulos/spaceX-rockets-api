package com.zair.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "rockets")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Rocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "stages", nullable = false)
    private Integer stages;

    @Column(name = "boosters", nullable = false)
    private Integer boosters;

    @Column(name = "cost_per_launch", nullable = false)
    private Long costPerLaunch;

    @Column(name = "success_rate_pct", nullable = false)
    private Integer successRatePct;

    @Temporal(TemporalType.DATE)
    @Column(name = "first_flight", nullable = false)
    private LocalDate firstFlight;

    @Column(name = "country", nullable = false)
    private String country;

    @OneToOne(mappedBy = "rocket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RocketHeight height;

    @OneToOne(mappedBy = "rocket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RocketDiameter diameter;

    @OneToOne(mappedBy = "rocket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RocketMass mass;
}
