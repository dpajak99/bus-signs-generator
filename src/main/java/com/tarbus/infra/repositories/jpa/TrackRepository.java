package com.tarbus.infra.repositories.jpa;

import com.tarbus.infra.entity.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<TrackEntity, String> {}
