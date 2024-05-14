package com.zair.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rocket_mass")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RocketMass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kg", nullable = false)
    private Long kg;

    @Column(name = "lb", nullable = false)
    private Long lb;

    @OneToOne
    @JoinColumn(name = "rocket_id")
    private Rocket rocket;
}
