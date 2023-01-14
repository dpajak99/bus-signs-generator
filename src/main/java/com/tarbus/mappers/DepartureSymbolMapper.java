package com.tarbus.mappers;

import com.tarbus.entity.DepartureSymbolEntity;
import com.tarbus.models.schedule.SymbolModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartureSymbolMapper {
    
    public List<SymbolModel> mapToModel(List<DepartureSymbolEntity> departureSymbolEntities) {
        return departureSymbolEntities.stream().map(this::mapToModel).toList();
    }
    public SymbolModel mapToModel(DepartureSymbolEntity departureSymbolEntity) {
        SymbolModel symbolModel = new SymbolModel();
        symbolModel.setSymbol(departureSymbolEntity.getId().getSymbols());
        symbolModel.setDirection(departureSymbolEntity.getBoardName());
        symbolModel.setDescription(departureSymbolEntity.getScheduleName());
        return symbolModel;
    }
}
