package com.zair.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RocketDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final Boolean active;
    private final Integer stages;
    private final Integer boosters;
    private final Long costPerLaunch;
    private final Integer successRatePct;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate firstFlight;
    private final String country;
    private final RocketDimensionDTO height;
    private final RocketDimensionDTO diameter;
    private final RocketMassDTO mass;
}
