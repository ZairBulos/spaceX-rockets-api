package com.zair.mappers;

import com.zair.models.dtos.RocketDimensionDTO;
import com.zair.models.entities.Rocket;
import com.zair.models.entities.RocketDiameter;
import com.zair.models.entities.RocketHeight;

public interface RocketDimensionMapper {

    RocketDimensionDTO toDTO(RocketHeight source);

    RocketDimensionDTO toDTO(RocketDiameter source);

    RocketHeight toEntityRocketHeight(RocketDimensionDTO source, Rocket rocket);

    RocketDiameter toEntityRocketDiameter(RocketDimensionDTO source, Rocket rocket);
}
