package com.tarbus.mappers;

import com.tarbus.entity.TimetableVersionEntity;
import com.tarbus.models.schedule.TimetableVersionModel;
import org.springframework.stereotype.Component;

@Component
public class TimetableVersionMapper {
    public TimetableVersionModel mapToModel(TimetableVersionEntity timetableVersionEntity) {
        TimetableVersionModel timetableVersionModel = new TimetableVersionModel();
        timetableVersionModel.setId(timetableVersionEntity.getId());
        timetableVersionModel.setCompany(timetableVersionEntity.getCompany());
//        timetableVersionModel.setDateStart(timetableVersionEntity.getDateStart());
//        timetableVersionModel.setDateEnd(timetableVersionEntity.getDateEnd());
        return timetableVersionModel;
    }
    
    public TimetableVersionEntity mapToEntity(TimetableVersionModel timetableVersionModel) {
        TimetableVersionEntity timetableVersionEntity = new TimetableVersionEntity();
        timetableVersionEntity.setId(timetableVersionModel.getId());
        timetableVersionEntity.setCompany(timetableVersionModel.getCompany());
//        timetableVersionEntity.setDateStart(timetableVersionModel.getDateStart());
//        timetableVersionEntity.setDateEnd(timetableVersionModel.getDateEnd());
        return timetableVersionEntity;
    }
}
