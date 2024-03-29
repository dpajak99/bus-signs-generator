package com.tarbus.services.jpa.impl;

import com.tarbus.models.schedule.timetable_template_model.TimetableTemplateModel;
import com.tarbus.entity.TimetableTemplateEntity;
import com.tarbus.repositories.jpa.TimetableTemplateRepository;
import com.tarbus.services.jpa.RouteService;
import com.tarbus.services.jpa.TimetableTemplateService;
import com.tarbus.mappers.TimetableTemplateMapper;
import com.tarbus.models.schedule.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimetableTemplateServiceImpl implements TimetableTemplateService {
    final TimetableTemplateRepository timetableTemplateRepository;
    final RouteService routeService;
    
    final TimetableTemplateMapper timetableTemplateMapper;

    @Autowired
    public TimetableTemplateServiceImpl(TimetableTemplateRepository timetableTemplateRepository, RouteService routeService, TimetableTemplateMapper timetableTemplateMapper) {
        this.timetableTemplateRepository = timetableTemplateRepository;
        this.routeService = routeService;
        this.timetableTemplateMapper = timetableTemplateMapper;
    }
    
    @Override
    public TimetableTemplateModel getTimetableTemplateById(String id) {
        TimetableTemplateEntity timetableTemplateEntity = timetableTemplateRepository.findById(id).get();
        return timetableTemplateMapper.mapToModel(timetableTemplateEntity);
    }

    @Override
    public TimetableTemplateModel getTimetableTemplateByRouteId(Long routeId) {
        Optional<TimetableTemplateEntity> routeTimetableTemplateEntity = timetableTemplateRepository.findByRouteId(routeId);
        if( routeTimetableTemplateEntity.isPresent() ) {
            return timetableTemplateMapper.mapToModel(routeTimetableTemplateEntity.get());
        }
    
        RouteModel routeModel = routeService.getRouteById(routeId);
        Long companyId = routeModel.getLine().getTimetableVersion().getCompany().getId();
        return getTimetableTemplateByCompanyId(companyId);
    }

    @Override
    public TimetableTemplateModel getTimetableTemplateByCompanyId(Long companyId) {
        TimetableTemplateEntity companyTimetableTemplateEntity = timetableTemplateRepository.findByCompanyId(companyId);
        return timetableTemplateMapper.mapToModel(companyTimetableTemplateEntity);
    }
}
