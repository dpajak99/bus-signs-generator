package com.tarbus.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TimetableBuilderOutput {
    private List<TimetableDocumentStructure> singleTimetables;
    private List<TimetableDocumentStructure> sharedTimetables;

    @Override
    public String toString() {
        return "TimetableBuilderOutput{" +
                "singleTimetables=" + singleTimetables +
                ", sharedTimetables=" + sharedTimetables +
                '}';
    }
}
