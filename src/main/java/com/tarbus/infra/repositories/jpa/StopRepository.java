package com.tarbus.infra.repositories.jpa;

import com.tarbus.infra.entity.StopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends JpaRepository<StopEntity, Long> {}
