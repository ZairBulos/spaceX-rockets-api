package com.zair.mappers.impl;

import com.zair.mappers.RocketDimensionMapper;
import com.zair.mappers.RocketMapper;
import com.zair.mappers.RocketMassMapper;
import com.zair.models.dtos.RocketDTO;
import com.zair.models.dtos.RocketInputDTO;
import com.zair.models.entities.Rocket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RocketMapperImpl implements RocketMapper {

    private final RocketDimensionMapper rocketDimensionMapper;
    private final RocketMassMapper rocketMassMapper;

    @Override
    public RocketDTO toDTO(Rocket source) {
        if (source == null) return null;

        return RocketDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .active(source.getActive())
                .stages(source.getStages())
                .boosters(source.getBoosters())
                .costPerLaunch(source.getCostPerLaunch())
                .successRatePct(source.getSuccessRatePct())
                .firstFlight(source.getFirstFlight())
                .country(source.getCountry())
                .height(rocketDimensionMapper.toDTO(source.getHeight()))
                .diameter(rocketDimensionMapper.toDTO(source.getDiameter()))
                .mass(rocketMassMapper.toDTO(source.getMass()))
                .build();
    }

    @Override
    public Rocket toEntity(RocketInputDTO source) {
        if (source == null) return null;

        Rocket rocket = Rocket.builder()
                .name(source.getName())
                .description(source.getDescription())
                .active(source.getActive())
                .stages(source.getStages())
                .boosters(source.getBoosters())
                .costPerLaunch(source.getCostPerLaunch())
                .successRatePct(source.getSuccessRatePct())
                .firstFlight(source.getFirstFlight())
                .country(source.getCountry())
                .build();

        rocket.setHeight(rocketDimensionMapper.toEntityRocketHeight(source.getHeight(), rocket));
        rocket.setDiameter(rocketDimensionMapper.toEntityRocketDiameter(source.getDiameter(), rocket));
        rocket.setMass(rocketMassMapper.toEntity(source.getMass(), rocket));

        return rocket;
    }

    @Override
    public List<RocketDTO> toDTOsList(List<Rocket> source) {
        if (source == null || source.isEmpty()) return null;

        return source.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
