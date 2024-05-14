package com.zair.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rocket_height")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RocketHeight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "meters", nullable = false)
    private Double meters;

    @Column(name = "feet", nullable = false)
    private Double feet;

    @OneToOne
    @JoinColumn(name = "rocket_id")
    private Rocket rocket;
}
