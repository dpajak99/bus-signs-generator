package com.tarbus.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TimetableDocumentStructure {
    private String fileName;
    private List<TimetablePageStructure> pages;

    @Override
    public String toString() {
        return "TimetableDocumentStructure{" +
                "fileName='" + fileName + '\'' +
                ", pages=" + pages +
                '}';
    }
}
