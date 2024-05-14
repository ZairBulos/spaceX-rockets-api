package com.zair.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data @Builder
public class RocketInputDTO {
    private String name;
    private String description;
    private Boolean active;
    private Integer stages;
    private Integer boosters;
    private Long costPerLaunch;
    private Integer successRatePct;
    private LocalDate firstFlight;
    private String country;
    private RocketDimensionDTO height;
    private RocketDimensionDTO diameter;
    private RocketMassDTO mass;
}
