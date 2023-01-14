package com.tarbus.mappers;

import com.tarbus.models.schedule.timetable_template_model.TimetableTemplateModel;
import com.tarbus.entity.TimetableTemplateEntity;
import com.tarbus.entity.TimetableTemplateType;
import com.tarbus.models.schedule.timetable_template_model.custom.Km001TimetableTemplateModel;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TimetableTemplateMapper {
    public TimetableTemplateModel mapToModel(TimetableTemplateEntity timetableTemplateEntity) {
        TimetableTemplateModel timetableTemplateModel;
        if(Objects.equals(timetableTemplateEntity.getId(), "km001")) {
            timetableTemplateModel = new Km001TimetableTemplateModel();
        } else {
            timetableTemplateModel = new TimetableTemplateModel();
        }
        timetableTemplateModel.setId(timetableTemplateEntity.getId());
        timetableTemplateModel.setUploaderId(timetableTemplateEntity.getUploaderId());
        timetableTemplateModel.setType(TimetableTemplateType.valueOf(timetableTemplateEntity.getType()));
        return timetableTemplateModel;
    }

    public TimetableTemplateEntity mapToEntity(TimetableTemplateModel timetableTemplateModel) {
        TimetableTemplateEntity timetableTemplateEntity = new TimetableTemplateEntity();
        timetableTemplateEntity.setId(timetableTemplateModel.getId());
        timetableTemplateEntity.setUploaderId(timetableTemplateModel.getUploaderId());
        timetableTemplateEntity.setType(timetableTemplateModel.getType().name());
        return timetableTemplateEntity;
    }
}
