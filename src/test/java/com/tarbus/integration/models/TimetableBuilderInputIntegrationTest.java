package com.tarbus.integration.models;

import com.tarbus.Application;
import com.tarbus.config.H2TestProfileJPAConfig;
import com.tarbus.services.generator.TimetableService;
import com.tarbus.models.RouteTimetable;
import com.tarbus.models.StopTimetableConfig;
import com.tarbus.models.TimetableBuilderInput;
import com.tarbus.models.schedule.StopModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        Application.class,
        H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class TimetableBuilderInputIntegrationTest {
    @Autowired
    private TimetableService timetableService;

    @Test
    public void testGetStopTimetables() {
        // Arrange
        TimetableBuilderInput timetableBuilderInput = new TimetableBuilderInput();

        RouteTimetable routeTimetable1 = timetableService.getRouteTimetableByRouteId(1L);
        RouteTimetable routeTimetable2 = timetableService.getRouteTimetableByRouteId(2L);

        List<RouteTimetable> routeTimetables = List.of(routeTimetable1, routeTimetable2);
        timetableBuilderInput.setRouteTimetables(routeTimetables);
        
        // Act
        Map<StopModel, List<StopTimetableConfig>> actualStopTimetables = timetableBuilderInput.getStopTimetables();
        
        // Assert
        Map<StopModel, List<StopTimetableConfig>> expectedStopTimetables = Map.of(
                routeTimetable1.getStopTimetableConfigs().get(0).getStop(), List.of(routeTimetable1.getStopTimetableConfigs().get(0), routeTimetable2.getStopTimetableConfigs().get(2)),
                routeTimetable1.getStopTimetableConfigs().get(1).getStop(), List.of(routeTimetable1.getStopTimetableConfigs().get(1), routeTimetable2.getStopTimetableConfigs().get(1)),
                routeTimetable1.getStopTimetableConfigs().get(2).getStop(), List.of(routeTimetable1.getStopTimetableConfigs().get(2), routeTimetable2.getStopTimetableConfigs().get(0))
        );
        assertEquals(expectedStopTimetables, actualStopTimetables);
    }
}
