package com.tarbus.services.jpa.impl;

import com.tarbus.entity.DepartureSymbolEntity;
import com.tarbus.repositories.jpa.DepartureSymbolRepository;
import com.tarbus.services.jpa.DepartureSymbolService;
import com.tarbus.mappers.DepartureSymbolMapper;
import com.tarbus.models.schedule.SymbolModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartureSymbolServiceImpl implements DepartureSymbolService {
    private final DepartureSymbolRepository departureSymbolRepository;
    
    private final DepartureSymbolMapper departureSymbolMapper;
    
    @Autowired
    public DepartureSymbolServiceImpl(DepartureSymbolRepository departureSymbolRepository, DepartureSymbolMapper departureSymbolMapper) {
        this.departureSymbolRepository = departureSymbolRepository;
        this.departureSymbolMapper = departureSymbolMapper;
    }

    @Override
    public List<SymbolModel> getBySymbolsNameAndRoute(String symbols, Long routeId) {
        Set<String> fullSymbols = new HashSet<>();
        fullSymbols.addAll(Arrays.stream(symbols.split(" ")).toList());
        fullSymbols.addAll(Arrays.stream(symbols.split("")).toList());
        List<String> fullSymbolsList = fullSymbols.stream().filter((e) -> !Objects.equals(e, " ") && !Objects.equals(e, "")).toList();
        List<DepartureSymbolEntity> departureSymbolEntities = new ArrayList<>();
        for(String symbol : fullSymbolsList ) {
            Optional<DepartureSymbolEntity> symbolEntity = departureSymbolRepository.findByNameAndRoute(symbol, routeId);
            if( symbolEntity.isPresent() ) {
                departureSymbolEntities.add(symbolEntity.get());
            } else {
                System.err.println("Cannot get symbol ["+symbol+"] for route ["+routeId+"]");
            }
        }
        return departureSymbolMapper.mapToModel(departureSymbolEntities);
    }
}
