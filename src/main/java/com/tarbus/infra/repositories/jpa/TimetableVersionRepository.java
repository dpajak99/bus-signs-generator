package com.tarbus.infra.repositories.jpa;

import com.tarbus.infra.entity.TimetableVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableVersionRepository extends JpaRepository<TimetableVersionEntity, Long> {}
