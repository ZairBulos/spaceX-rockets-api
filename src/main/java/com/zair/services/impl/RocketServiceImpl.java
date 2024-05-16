package com.zair.services.impl;

import com.zair.exceptions.RocketCreationException;
import com.zair.exceptions.RocketNotFoundException;
import com.zair.exceptions.RocketUpdateException;
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
import org.springframework.dao.DataIntegrityViolationException;
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
        Rocket rocket = rocketRepository.findById(id)
                .orElseThrow(() -> new RocketNotFoundException("Rocket not found with id: " + id));
        return rocketMapper.toDTO(rocket);
    }

    @Override
    @Transactional
    public RocketDTO save(RocketInputDTO rocketInput) {
        try {
            Rocket rocket = rocketMapper.toEntity(rocketInput);
            Rocket savedRocket = rocketRepository.save(rocket);

            rocketRepository.flush();

            return rocketMapper.toDTO(savedRocket);
        } catch (DataIntegrityViolationException e) {
            throw new RocketCreationException("Failed to save rocket: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public RocketDTO update(Long id, RocketInputDTO rocketInput) {
        try {
            Rocket rocket = rocketRepository.findById(id)
                    .orElseThrow(() -> new RocketNotFoundException("Rocket not found with id: " + id));
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

            Rocket updatedRocket = rocketRepository.save(rocket);

            rocketRepository.flush();

            return rocketMapper.toDTO(updatedRocket);
        } catch (DataIntegrityViolationException e) {
            throw new RocketUpdateException("Failed to update rocket with id " + id + ": " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        if (!rocketRepository.existsById(id)) {
            throw new RocketNotFoundException("Rocket not found with id: " + id);
        }

        rocketRepository.deleteById(id);
        return true;
    }
}
