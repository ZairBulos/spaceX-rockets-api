package com.zair.mappers;

import com.zair.models.dtos.RocketMassDTO;
import com.zair.models.entities.Rocket;
import com.zair.models.entities.RocketMass;

public interface RocketMassMapper {

    RocketMassDTO toDTO(RocketMass source);

    RocketMass toEntity(RocketMassDTO source, Rocket rocket);
}
