package com.tarbus.models.schedule;

import com.tarbus.utils.TimeUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class DepartureModel implements Comparable<DepartureModel> {
    private int timeInMin;
    
    private TrackModel track;
    
    private List<SymbolModel> symbols;
    
    public List<String> getSymbolsString() {
        return symbols.stream().map(SymbolModel::getSymbol).toList();
    }
    
    public String getTimeString(String format) {
        return TimeUtils.getFormattedTime(timeInMin, format, false);
    }

    @Override
    public String toString() {
        return "DepartureModel{" +
                "timeInMin=" + timeInMin +
                ", track=" + track +
                ", symbols=" + symbols +
                '}';
    }

    @Override
    public int compareTo(DepartureModel departureModel) {
        int timeCompare = Integer.compare(timeInMin, departureModel.getTimeInMin());
        if (timeCompare != 0) {
            return timeCompare;
        }
        String thisSymbols = String.join(",", getSymbolsString());
        String otherSymbols = String.join(",", departureModel.getSymbolsString());
        return thisSymbols.compareTo(otherSymbols);
    }
}
