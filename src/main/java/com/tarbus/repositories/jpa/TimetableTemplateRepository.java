package com.tarbus.repositories.jpa;

import com.tarbus.entity.TimetableTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimetableTemplateRepository  extends JpaRepository<TimetableTemplateEntity, String> {
    @Query("select rtt.id.timetableTemplate from RouteTimetableTemplateEntity rtt where rtt.id.route.id = ?1")
    Optional<TimetableTemplateEntity> findByRouteId(Long routeId);
    
    @Query("select ctt.id.template from CompanyTimetableTemplate ctt where ctt.id.company.id = ?1")
    TimetableTemplateEntity findByCompanyId(Long companyId);
}
