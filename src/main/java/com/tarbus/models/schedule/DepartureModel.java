package com.tarbus.models.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class DepartureModel {
    private int timeInMin;
    
    private TrackModel track;
    
    private List<SymbolModel> symbols;
    
    public List<String> getSymbolsString() {
        return symbols.stream().map(SymbolModel::getSymbol).toList();
    }
    
    public String getTimeString() {
        int hours = timeInMin / 60;
        int minutes = timeInMin % 60;
        String hoursString = String.valueOf(hours);
        String minutesString = String.valueOf(minutes);
        if( minutes < 10 ) {
            minutesString = "0" + minutesString;
        }
        return hoursString + ":" + minutesString;
    }
}
