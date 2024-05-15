package com.zair.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.zair.mappers.RocketMapper;
import com.zair.models.dtos.RocketDTO;
import com.zair.models.dtos.RocketDimensionDTO;
import com.zair.models.dtos.RocketInputDTO;
import com.zair.models.dtos.RocketMassDTO;
import com.zair.models.entities.Rocket;
import com.zair.models.entities.RocketDiameter;
import com.zair.models.entities.RocketHeight;
import com.zair.models.entities.RocketMass;
import com.zair.repositories.RocketRepository;
import com.zair.services.impl.RocketServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RocketServiceTest {

    @Mock
    private RocketRepository rocketRepositoryMock;

    @Mock
    private RocketMapper rocketMapperMock;

    @InjectMocks
    private RocketServiceImpl rocketService;

    @Test
    public void testFindAllEmptyList() {
        // Arrange
        when(rocketRepositoryMock.findAll()).thenReturn(Collections.emptyList());
        when(rocketMapperMock.toDTOsList(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Act
        rocketService.findAll();

        // Assert
        verify(rocketRepositoryMock, times(1)).findAll();
        verify(rocketMapperMock, times(1)).toDTOsList(Collections.emptyList());
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Rocket> rockets = new ArrayList<>();
        rockets.add(Rocket.builder().build());

        List<RocketDTO> rocketDTOsList = new ArrayList<>();
        rocketDTOsList.add(RocketDTO.builder().build());

        when(rocketRepositoryMock.findAll()).thenReturn(rockets);
        when(rocketMapperMock.toDTOsList(rockets)).thenReturn(rocketDTOsList);

        // Act
        List<RocketDTO> result = rocketService.findAll();

        // Assert
        assertEquals(rocketDTOsList, result);
    }

    @Test
    public void testFindById() {
        // Arrange
        Long rocketId = 1L;
        Rocket rocket = Rocket.builder().id(rocketId).build();
        RocketDTO rocketDTO = RocketDTO.builder().id(rocketId).build();

        when(rocketRepositoryMock.findById(rocketId)).thenReturn(Optional.of(rocket));
        when(rocketMapperMock.toDTO(rocket)).thenReturn(rocketDTO);

        // Act
        RocketDTO result = rocketService.findById(rocketId);

        // Assert
        assertEquals(rocketDTO, result);
    }

    @Test
    public void testSave() {
        // Arrange
        RocketInputDTO rocketInput = RocketInputDTO.builder()
                .name("Falcon 9")
                .description("Falcon 9 is a reusable, two-stage rocket designed and manufactured by SpaceX.")
                .active(true)
                .stages(2)
                .boosters(0)
                .costPerLaunch(50000000L)
                .successRatePct(97)
                .firstFlight(LocalDate.of(2010, 6, 4))
                .country("United States")
                .height(RocketDimensionDTO.builder().meters(70.0).feet(229.6).build())
                .diameter(RocketDimensionDTO.builder().meters(3.7).feet(12.0).build())
                .mass(RocketMassDTO.builder().kg(549054L).lb(1207920L).build())
                .build();

        Rocket rocket = Rocket.builder()
                .name("Falcon 9")
                .description("Falcon 9 is a reusable, two-stage rocket designed and manufactured by SpaceX.")
                .active(true)
                .stages(2)
                .boosters(0)
                .costPerLaunch(50000000L)
                .successRatePct(97)
                .firstFlight(LocalDate.of(2010, 6, 4))
                .country("United States")
                .build();
        rocket.setHeight(RocketHeight.builder().meters(70.0).feet(229.6).rocket(rocket).build());
        rocket.setDiameter(RocketDiameter.builder().meters(3.7).feet(12.0).rocket(rocket).build());
        rocket.setMass(RocketMass.builder().kg(549054L).lb(1207920L).rocket(rocket).build());

        Rocket savedRocket = rocket;
        savedRocket.setId(1L);

        RocketDTO rocketDTO = RocketDTO.builder()
                .id(1L)
                .name("Falcon 9")
                .description("Falcon 9 is a reusable, two-stage rocket designed and manufactured by SpaceX.")
                .active(true)
                .stages(2)
                .boosters(0)
                .costPerLaunch(50000000L)
                .successRatePct(97)
                .firstFlight(LocalDate.of(2010, 6, 4))
                .country("United States")
                .height(RocketDimensionDTO.builder().meters(70.0).feet(229.6).build())
                .diameter(RocketDimensionDTO.builder().meters(3.7).feet(12.0).build())
                .mass(RocketMassDTO.builder().kg(549054L).lb(1207920L).build())
                .build();

        when(rocketMapperMock.toEntity(rocketInput)).thenReturn(rocket);
        when(rocketRepositoryMock.save(rocket)).thenReturn(savedRocket);
        when(rocketMapperMock.toDTO(savedRocket)).thenReturn(rocketDTO);

        // Act
        RocketDTO result = rocketService.save(rocketInput);

        // Assert
        assertEquals(rocketDTO, result);
    }

    @Test
    public void testUpdate() {
        // Arrange
        Long rocketId = 1L;
        RocketInputDTO rocketInput = RocketInputDTO.builder()
                .name("Falcon Heavy")
                .description("Falcon Heavy is a partially reusable heavy-lift launch vehicle designed and manufactured by SpaceX.")
                .active(true)
                .stages(2)
                .boosters(2)
                .costPerLaunch(90000000L)
                .successRatePct(100)
                .firstFlight(LocalDate.of(2018, 2, 6))
                .country("United States")
                .height(RocketDimensionDTO.builder().meters(70.0).feet(229.6).build())
                .diameter(RocketDimensionDTO.builder().meters(3.7).feet(12.0).build())
                .mass(RocketMassDTO.builder().kg(1420788L).lb(3125735L).build())
                .build();

        Rocket rocket = Rocket.builder()
                .id(rocketId)
                .name("Falcon 9")
                .description("Falcon 9 is a reusable, two-stage rocket designed and manufactured by SpaceX.")
                .active(true)
                .stages(2)
                .boosters(0)
                .costPerLaunch(50000000L)
                .successRatePct(97)
                .firstFlight(LocalDate.of(2010, 6, 4))
                .country("United States")
                .build();
        rocket.setHeight(RocketHeight.builder().meters(70.0).feet(229.6).rocket(rocket).build());
        rocket.setDiameter(RocketDiameter.builder().meters(3.7).feet(12.0).rocket(rocket).build());
        rocket.setMass(RocketMass.builder().kg(549054L).lb(1207920L).rocket(rocket).build());

        Rocket updatedRocket = Rocket.builder()
                .id(rocketId)
                .name("Falcon Heavy")
                .description("Falcon Heavy is a partially reusable heavy-lift launch vehicle designed and manufactured by SpaceX.")
                .active(true)
                .stages(2)
                .boosters(2)
                .costPerLaunch(90000000L)
                .successRatePct(100)
                .firstFlight(LocalDate.of(2018, 2, 6))
                .country("United States")
                .build();
        updatedRocket.setHeight(RocketHeight.builder().meters(70.0).feet(229.6).rocket(updatedRocket).build());
        updatedRocket.setDiameter(RocketDiameter.builder().meters(3.7).feet(12.0).rocket(updatedRocket).build());
        updatedRocket.setMass(RocketMass.builder().kg(1420788L).lb(3125735L).rocket(updatedRocket).build());

        RocketDTO rocketDTO = RocketDTO.builder()
                .id(rocketId)
                .name("Falcon Heavy")
                .description("Falcon Heavy is a partially reusable heavy-lift launch vehicle designed and manufactured by SpaceX.")
                .active(true)
                .stages(2)
                .boosters(2)
                .costPerLaunch(90000000L)
                .successRatePct(100)
                .firstFlight(LocalDate.of(2018, 2, 6))
                .country("United States")
                .height(RocketDimensionDTO.builder().meters(70.0).feet(229.6).build())
                .diameter(RocketDimensionDTO.builder().meters(3.7).feet(12.0).build())
                .mass(RocketMassDTO.builder().kg(1420788L).lb(3125735L).build())
                .build();

        when(rocketRepositoryMock.findById(rocketId)).thenReturn(Optional.of(rocket));
        when(rocketRepositoryMock.save(rocket)).thenReturn(updatedRocket);
        when(rocketMapperMock.toDTO(updatedRocket)).thenReturn(rocketDTO);

        // Act
        RocketDTO result = rocketService.update(rocketId, rocketInput);

        // Assert
        assertEquals(rocketDTO, result);
    }

    @Test
    public void testDelete() {
        // Arrange
        Long rocketId = 1L;
        doNothing().when(rocketRepositoryMock).deleteById(rocketId);

        // Act
        Boolean result = rocketService.delete(rocketId);

        // Assert
        assertTrue(result);
        verify(rocketRepositoryMock, times(1)).deleteById(rocketId);
    }
}
