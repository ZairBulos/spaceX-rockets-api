package com.zair.services.impl;

import com.zair.mappers.RocketMapper;
import com.zair.models.dtos.RocketDTO;
import com.zair.models.dtos.RocketInputDTO;
import com.zair.models.entities.Rocket;
import com.zair.models.entities.RocketDiameter;
import com.zair.models.entities.RocketHeight;
import com.zair.models.entities.RocketMass;
import com.zair.repositories.RocketRepository;
import com.zair.services.RocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RocketServiceImpl implements RocketService {

    private final RocketRepository rocketRepository;
    private final RocketMapper rocketMapper;

    @Override
    public List<RocketDTO> findAll() {
        List<Rocket> rockets = rocketRepository.findAll();
        return rocketMapper.toDTOsList(rockets);
    }

    @Override
    public RocketDTO findById(Long id) {
        Rocket rocket = rocketRepository.findById(id).get();
        return rocketMapper.toDTO(rocket);
    }

    @Override
    @Transactional
    public RocketDTO save(RocketInputDTO rocketInput) {
        Rocket rocket = rocketMapper.toEntity(rocketInput);
        return rocketMapper.toDTO(rocketRepository.save(rocket));
    }

    @Override
    @Transactional
    public RocketDTO update(Long id, RocketInputDTO rocketInput) {
        Rocket rocket = rocketRepository.findById(id).get();
        rocket.setName(rocketInput.getName());
        rocket.setDescription(rocketInput.getDescription());
        rocket.setActive(rocketInput.getActive());
        rocket.setStages(rocketInput.getStages());
        rocket.setBoosters(rocketInput.getBoosters());
        rocket.setCostPerLaunch(rocketInput.getCostPerLaunch());
        rocket.setSuccessRatePct(rocketInput.getSuccessRatePct());
        rocket.setFirstFlight(rocketInput.getFirstFlight());
        rocket.setCountry(rocketInput.getCountry());

        RocketHeight height = rocket.getHeight();
        height.setMeters(rocketInput.getHeight().getMeters());
        height.setFeet(rocketInput.getHeight().getFeet());
        rocket.setHeight(height);

        RocketDiameter diameter = rocket.getDiameter();
        diameter.setMeters(rocketInput.getDiameter().getMeters());
        diameter.setFeet(rocketInput.getDiameter().getFeet());
        rocket.setDiameter(diameter);

        RocketMass mass = rocket.getMass();
        mass.setKg(rocketInput.getMass().getKg());
        mass.setLb(rocketInput.getMass().getLb());
        rocket.setMass(mass);

        return rocketMapper.toDTO(rocketRepository.save(rocket));
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        rocketRepository.deleteById(id);
        return true;
    }
}
