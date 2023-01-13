package com.tarbus.infra.repositories.jpa;

import com.tarbus.infra.entity.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<LineEntity, Long> {}
