package com.tarbus.models;

import com.tarbus.models.schedule.RouteModel;
import com.tarbus.models.schedule.timetable_template_model.TimetableTemplateModel;
import com.tarbus.models.timetable_template_content.MultiTimetableTemplateContent;
import com.tarbus.models.timetable_template_content.SingleTimetableTemplateContent;
import com.tarbus.models.timetable_template_content.TimetableTemplateContent;
import com.tarbus.models.timetable_data.SingleTimetableData;
import com.tarbus.utils.TimetableTemplateResolver;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.*;

@Getter
@Setter
public class TimetablePageStructure { 
    private static final String htmlFooter = "</body></html>";
    private List<TimetableTemplateContent> structure;

    public TimetablePageStructure() {
        this.structure = new ArrayList<>();
    }

    public void add(TimetableTemplateModel timetableTemplate, SingleTimetableData stopSingleTimetableData) {
        if (timetableTemplate.isMultipleTemplate()) {
            addOrCreateMultitemplateIfExists(timetableTemplate, stopSingleTimetableData);
        } else {
            structure.add(new SingleTimetableTemplateContent(timetableTemplate, stopSingleTimetableData, stopSingleTimetableData.getRoute()));
        }
    }
    
    public List<RouteModel> getPageRoutes() {
        Set<RouteModel> routes = new HashSet<>();
        for (TimetableTemplateContent timetableTemplateContent : structure) {
                routes.addAll(timetableTemplateContent.getRoutes());
        }
        return new ArrayList<>(routes);
    }

    public String buildHtml() throws IOException {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(getHtmlHeader());
        for (TimetableTemplateContent timetableTemplateContent : structure) {
            TimetableTemplateModel timetableTemplate = timetableTemplateContent.getTimetableTemplate();
            htmlBuilder.append(timetableTemplate.process(timetableTemplateContent));
        }
        htmlBuilder.append(htmlFooter);

        return htmlBuilder.toString();
    }


    private void addOrCreateMultitemplateIfExists(TimetableTemplateModel timetableTemplate, SingleTimetableData stopSingleTimetableData) {
        if (structure.isEmpty()) {
            structure.add(new MultiTimetableTemplateContent(timetableTemplate, List.of(stopSingleTimetableData), List.of(stopSingleTimetableData.getRoute())));
            return;
        }

        List<TimetableTemplateContent> tmpStructure = new ArrayList<>(structure);
        for (TimetableTemplateContent timetableTemplateContent : tmpStructure) {
            if (timetableTemplateContent instanceof MultiTimetableTemplateContent multiTemplate && multiTemplate.getTimetableTemplate().equals(timetableTemplate)) {
                multiTemplate.add(stopSingleTimetableData, stopSingleTimetableData.getRoute());
                return;
            }
        }
        structure.add(new MultiTimetableTemplateContent(timetableTemplate, List.of(stopSingleTimetableData), List.of(stopSingleTimetableData.getRoute())));
    }
    private String getHtmlHeader() throws IOException {
        List<String> timetableIds = new ArrayList<>();
        for(TimetableTemplateContent timetableTemplateContent : structure) {
            timetableIds.add(timetableTemplateContent.getTimetableTemplate().getId());
        }
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("title", "Timetables");
        variables.put("timetableTemplates", timetableIds);

        return TimetableTemplateResolver.resolveBaseFile("header", variables);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimetablePageStructure)) return false;
        TimetablePageStructure that = (TimetablePageStructure) o;
        return Objects.equals(structure, that.structure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(structure);
    }

    @Override
    public String toString() {
        return "TimetablePageStructure{" +
                "structure=" + structure +
                '}';
    }
}
