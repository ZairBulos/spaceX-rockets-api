package com.zair.mappers.impl;

import com.zair.mappers.RocketMassMapper;
import com.zair.models.dtos.RocketInputDTO;
import com.zair.models.dtos.RocketMassDTO;
import com.zair.models.entities.Rocket;
import com.zair.models.entities.RocketMass;
import org.springframework.stereotype.Component;

@Component
public class RocketMassMapperImpl implements RocketMassMapper {

    @Override
    public RocketMassDTO toDTO(RocketMass source) {
        if (source == null) return null;

        return RocketMassDTO.builder()
                .kg(source.getKg())
                .lb(source.getLb())
                .build();
    }

    @Override
    public RocketMass toEntity(RocketMassDTO source, Rocket rocket) {
        if (source == null || rocket == null) return null;

        return RocketMass.builder()
                .kg(source.getKg())
                .lb(source.getLb())
                .rocket(rocket)
                .build();
    }
}
