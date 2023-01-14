package com.tarbus.repositories.jpa;

import com.tarbus.entity.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<LineEntity, Long> {}
