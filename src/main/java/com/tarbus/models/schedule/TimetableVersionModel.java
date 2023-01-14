package com.tarbus.models.schedule;

import lombok.Getter;
import lombok.Setter;
import com.tarbus.entity.CompanyEntity;

import java.util.Date;

@Getter
@Setter
public class TimetableVersionModel {
    private Long id;
    
    private CompanyEntity company;
    
    private Date dateStart;
    
    private Date dateEnd;

    @Override
    public String toString() {
        return "TimetableVersionModel{" +
                "id=" + id +
                ", company=" + company +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
