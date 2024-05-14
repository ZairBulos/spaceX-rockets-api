package com.zair.mappers.impl;

import com.zair.mappers.RocketDimensionMapper;
import com.zair.models.dtos.RocketDimensionDTO;
import com.zair.models.entities.Rocket;
import com.zair.models.entities.RocketDiameter;
import com.zair.models.entities.RocketHeight;
import org.springframework.stereotype.Component;

@Component
public class RocketDimensionMapperImpl implements RocketDimensionMapper {

    @Override
    public RocketDimensionDTO toDTO(RocketHeight source) {
        if (source == null) return null;

        return RocketDimensionDTO.builder()
                .meters(source.getMeters())
                .feet(source.getFeet())
                .build();
    }

    @Override
    public RocketDimensionDTO toDTO(RocketDiameter source) {
        if (source == null) return null;

        return RocketDimensionDTO.builder()
                .meters(source.getMeters())
                .feet(source.getFeet())
                .build();
    }

    @Override
    public RocketHeight toEntityRocketHeight(RocketDimensionDTO source, Rocket rocket) {
        if (source == null || rocket == null) return null;

        return RocketHeight.builder()
                .meters(source.getMeters())
                .feet(source.getFeet())
                .rocket(rocket)
                .build();
    }

    @Override
    public RocketDiameter toEntityRocketDiameter(RocketDimensionDTO source, Rocket rocket) {
        if (source == null || rocket == null) return null;

        return RocketDiameter.builder()
                .meters(source.getMeters())
                .feet(source.getFeet())
                .rocket(rocket)
                .build();
    }
}
