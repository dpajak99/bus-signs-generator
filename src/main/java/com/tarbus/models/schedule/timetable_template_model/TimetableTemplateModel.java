package com.tarbus.models.schedule.timetable_template_model;

import com.tarbus.models.timetable_template_content.TimetableTemplateContent;
import com.tarbus.utils.TimetableTemplateResolver;
import com.tarbus.utils.file_naming_policy.FileNamingPolicy;
import com.tarbus.utils.file_naming_policy.RouteIdFileNamingPolicy;
import lombok.Getter;
import lombok.Setter;
import com.tarbus.entity.TimetableTemplateType;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class TimetableTemplateModel {
    static String baseTemplatePath = "/home/dpajak99/Storage/GitHub/inzynierka/timetablegenerator/timetablegenerator/input/";
    private String id;
    private String uploaderId;
    private TimetableTemplateType type;
    
    public String process(TimetableTemplateContent timetableTemplateContent) throws IOException {
        Map<String, Object> variables = Map.of("timetable", timetableTemplateContent.getTimeTableData());
       return  TimetableTemplateResolver.resolveTemplateFile(timetableTemplateContent.getTimetableTemplate().getId(), variables);
    }
    
    public boolean isMultipleTemplate() {
        return type != TimetableTemplateType.by_route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimetableTemplateModel that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TimetableTemplateModel{" +
                "id='" + id + '\'' +
                ", uploaderId='" + uploaderId + '\'' +
                ", type=" + type +
                '}';
    }
}
