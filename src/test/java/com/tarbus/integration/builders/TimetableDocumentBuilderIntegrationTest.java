package com.tarbus.integration.builders;

import com.tarbus.Application;
import com.tarbus.builders.TimetableDocumentBuilder;
import com.tarbus.config.H2TestProfileJPAConfig;
import com.tarbus.services.generator.TimetableService;
import com.tarbus.models.RouteTimetable;
import com.tarbus.models.TimetableBuilderInput;
import com.tarbus.models.TimetableBuilderOutput;
import com.tarbus.models.TimetableDocumentStructure;
import com.tarbus.utils.file_naming_policy.RouteIdFileNamingPolicy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        Application.class,
        H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class TimetableDocumentBuilderIntegrationTest {
    @Autowired
    private TimetableService timetableService;

    @Test
    public void testGenerate1() {
        // Arrange
        TimetableDocumentBuilder timetableDocumentBuilder = new TimetableDocumentBuilder();
        timetableDocumentBuilder.setFileNamingPolicy(new RouteIdFileNamingPolicy());

        RouteTimetable from1 = timetableService.getRouteTimetableByRouteId(1L);

        TimetableBuilderInput timetableBuilderInput = new TimetableBuilderInput();
        timetableBuilderInput.setRouteTimetables(List.of(from1));

        // Act
        TimetableBuilderOutput actualTimetableBuilderOutput = timetableDocumentBuilder.generate(timetableBuilderInput);

        // Assert
        assertEquals(0, actualTimetableBuilderOutput.getSharedTimetables().size());
        assertEquals(List.of(), actualTimetableBuilderOutput.getSharedTimetables().stream().map(TimetableDocumentStructure::getFileName).toList());

        assertEquals(1, actualTimetableBuilderOutput.getSingleTimetables().size());
        assertEquals(List.of("1"), actualTimetableBuilderOutput.getSingleTimetables().stream().map(TimetableDocumentStructure::getFileName).toList());
    }
    
    @Test
    public void testGenerate2() {
        // Arrange
        TimetableDocumentBuilder timetableDocumentBuilder = new TimetableDocumentBuilder();
        timetableDocumentBuilder.setFileNamingPolicy(new RouteIdFileNamingPolicy());
        
        RouteTimetable from1 = timetableService.getRouteTimetableByRouteId(1L);
        RouteTimetable to1 = timetableService.getRouteTimetableByRouteId(2L);
        
        TimetableBuilderInput timetableBuilderInput = new TimetableBuilderInput();
        timetableBuilderInput.setRouteTimetables(List.of(from1, to1));

        // Act
        TimetableBuilderOutput actualTimetableBuilderOutput = timetableDocumentBuilder.generate(timetableBuilderInput);
        
        // Assert
        assertEquals(1, actualTimetableBuilderOutput.getSharedTimetables().size());
        assertEquals(List.of("1_2"), actualTimetableBuilderOutput.getSharedTimetables().stream().map(TimetableDocumentStructure::getFileName).toList());
        
        assertEquals(2, actualTimetableBuilderOutput.getSingleTimetables().size());
        assertEquals(List.of("1", "2"), actualTimetableBuilderOutput.getSingleTimetables().stream().map(TimetableDocumentStructure::getFileName).toList());
    }

    @Test
    public void testGenerate3() {
        // Arrange
        TimetableDocumentBuilder timetableDocumentBuilder = new TimetableDocumentBuilder();
        timetableDocumentBuilder.setFileNamingPolicy(new RouteIdFileNamingPolicy());

        RouteTimetable from1 = timetableService.getRouteTimetableByRouteId(1L);
        RouteTimetable to1 = timetableService.getRouteTimetableByRouteId(2L);
        RouteTimetable from2 = timetableService.getRouteTimetableByRouteId(3L);
        RouteTimetable to2 = timetableService.getRouteTimetableByRouteId(4L);

        TimetableBuilderInput timetableBuilderInput = new TimetableBuilderInput();
        timetableBuilderInput.setRouteTimetables(List.of(from1, to1, from2, to2));

        // Act
        TimetableBuilderOutput actualTimetableBuilderOutput = timetableDocumentBuilder.generate(timetableBuilderInput);

        // Assert
        assertEquals(3, actualTimetableBuilderOutput.getSharedTimetables().size());
        assertEquals(List.of("1_2", "3_4", "1_2_3_4"), actualTimetableBuilderOutput.getSharedTimetables().stream().map(TimetableDocumentStructure::getFileName).toList());

        assertEquals(4, actualTimetableBuilderOutput.getSingleTimetables().size());
        assertEquals(List.of("1", "2", "3", "4"), actualTimetableBuilderOutput.getSingleTimetables().stream().map(TimetableDocumentStructure::getFileName).toList());
    }
}
