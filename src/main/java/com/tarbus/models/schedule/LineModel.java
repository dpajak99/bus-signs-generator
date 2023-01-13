package com.tarbus.models.schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineModel {
    private Long id;
    
    private TimetableVersionModel timetableVersion;
    
    private String name;
    
    private String comments;

    @Override
    public String toString() {
        return "LineModel{" +
                "id=" + id +
                ", timetableVersion=" + timetableVersion +
                ", name='" + name + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
