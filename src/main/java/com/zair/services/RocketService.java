package com.zair.services;

import com.zair.models.dtos.RocketDTO;
import com.zair.models.dtos.RocketInputDTO;

import java.util.List;

public interface RocketService {

    List<RocketDTO> findAll();

    RocketDTO findById(Long id);

    RocketDTO save(RocketInputDTO rocketInput);

    RocketDTO update(Long id, RocketInputDTO rocketInput);

    Boolean delete(Long id);
}
