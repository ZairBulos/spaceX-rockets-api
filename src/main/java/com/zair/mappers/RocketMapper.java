package com.zair.mappers;

import com.zair.models.dtos.RocketDTO;
import com.zair.models.dtos.RocketInputDTO;
import com.zair.models.entities.Rocket;

import java.util.List;

public interface RocketMapper {

    RocketDTO toDTO(Rocket source);

    Rocket toEntity(RocketInputDTO source);

    List<RocketDTO> toDTOsList(List<Rocket> source);
}
