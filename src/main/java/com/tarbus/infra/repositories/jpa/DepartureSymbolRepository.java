package com.tarbus.infra.repositories.jpa;

import com.tarbus.infra.entity.DepartureSymbolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartureSymbolRepository extends JpaRepository<DepartureSymbolEntity, DepartureSymbolEntity.DepartureSymbolEntityId>  {
    @Query(" select dse from DepartureSymbolEntity dse where dse.id.symbols = ?1 and dse.id.route.id = ?2")
    Optional<DepartureSymbolEntity> findByNameAndRoute(String name, Long routeId);
}
