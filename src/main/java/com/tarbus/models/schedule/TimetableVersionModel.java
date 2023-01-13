package com.tarbus.models.schedule;

import lombok.Getter;
import lombok.Setter;
import com.tarbus.infra.entity.CompanyEntity;

import java.util.Date;

@Getter
@Setter
public class TimetableVersionModel {
    private Long id;
    
    private CompanyEntity company;
    
    private Date dateStart;
    
    private Date dateEnd;
}