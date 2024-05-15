package com.zair.controllers;

import com.zair.models.dtos.RocketDTO;
import com.zair.models.dtos.RocketInputDTO;
import com.zair.services.RocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RocketController {

    private final RocketService service;

    @QueryMapping
    public List<RocketDTO> getAllRockets() {
        return service.findAll();
    }

    @QueryMapping
    public RocketDTO getRocketById(@Argument Long id) {
        return service.findById(id);
    }

    @MutationMapping
    public RocketDTO createRocket(@Argument RocketInputDTO rocketInput) {
        return service.save(rocketInput);
    }

    @MutationMapping
    public RocketDTO updateRocket(@Argument Long id, @Argument RocketInputDTO rocketInput) {
        return service.update(id, rocketInput);
    }

    @MutationMapping
    public Boolean deleteRocket(@Argument Long id) {
        return service.delete(id);
    }
}
