package com.zair.repositories;

import com.zair.models.entities.Rocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RocketRepository extends JpaRepository<Rocket, Long> {
}
