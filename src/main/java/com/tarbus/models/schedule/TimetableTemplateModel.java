package com.tarbus.models.schedule;

import com.tarbus.utils.TimetableTemplateResolver;
import lombok.Getter;
import lombok.Setter;
import com.tarbus.models.TimetablePageStructure;
import com.tarbus.infra.entity.TimetableTemplateType;

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
    
    public String process(TimetablePageStructure.Template template) throws IOException {
        Map<String, Object> variables = Map.of("timetable", template.getTimeTableData());
       return  TimetableTemplateResolver.resolveTemplateFile(template.getTimetableTemplate().getId(), variables);
    }
    
    public boolean isMultipleTemplate() {
        return true;
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
}
