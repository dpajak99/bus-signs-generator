package com.tarbus.infra.repositories.jpa;


import com.tarbus.infra.entity.DepartureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartureRepository extends JpaRepository<DepartureEntity, Long> {
    @Query( "select d from DepartureEntity d where d.stop.id = ?1 and d.track.route.id = ?2" )
    List<DepartureEntity> findByStopAndRoute(Long stopId, Long routeId);
}
