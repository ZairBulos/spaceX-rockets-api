package com.zair.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class RocketDimensionDTO {
    private final Double meters;
    private final Double feet;
}
