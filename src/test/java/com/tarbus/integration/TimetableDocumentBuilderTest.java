package com.tarbus.integration;

import com.tarbus.Application;
import com.tarbus.builders.TimetableDocumentBuilder;
import com.tarbus.infra.services.generator.TimetableService;
import com.tarbus.models.RouteTimetable;
import com.tarbus.models.TimetableBuilderInput;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TimetableDocumentBuilderTest {
    @Autowired
    final TimetableService timetableService;

    @Autowired
    public TimetableDocumentBuilderTest(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    public void testGetTimetablePageStructure() {
        RouteTimetable a2From = timetableService.getRouteTimetableByRouteId(237L);
        RouteTimetable a2to = timetableService.getRouteTimetableByRouteId(236L);

        TimetableDocumentBuilder timetableDocumentBuilder = new TimetableDocumentBuilder();
        TimetableBuilderInput timetableBuilderInput = new TimetableBuilderInput();
        
        timetableDocumentBuilder.generate()
        
    }
}
