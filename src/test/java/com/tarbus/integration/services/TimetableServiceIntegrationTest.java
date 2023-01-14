package com.tarbus.integration.services;

import com.tarbus.Application;
import com.tarbus.config.H2TestProfileJPAConfig;
import com.tarbus.entity.TimetableTemplateType;
import com.tarbus.models.schedule.timetable_template_model.TimetableTemplateModel;
import com.tarbus.services.generator.TimetableService;
import com.tarbus.models.DeparturesWrapper;
import com.tarbus.models.RouteTimetable;
import com.tarbus.models.StopTimetableConfig;
import com.tarbus.models.schedule.*;
import com.tarbus.models.timetable_data.SingleTimetableData;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        Application.class,
        H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class TimetableServiceIntegrationTest extends TestCase {
    @Autowired
    private TimetableService timetableService;

    @Test
    public void testGenerate1() {
        // Act
        RouteTimetable actualRouteTimetable = timetableService.getRouteTimetableByRouteId(1L);
        
        // Assert
        RouteTimetable expectedRouteTimetable = getMockedRouteTimetable1();
        
        assertEquals(expectedRouteTimetable.toString(), actualRouteTimetable.toString());
    }
    
    RouteTimetable getMockedRouteTimetable1() {
        LineModel line = new LineModel();
        line.setId(1L);
        line.setName("TEST_LINE_1");
        
        RouteModel route = new RouteModel();
        route.setId(1L);
        route.setLine(line);
        
        TimetableTemplateModel timetableTemplate = new TimetableTemplateModel();
        timetableTemplate.setId("test_template_1");
        timetableTemplate.setUploaderId("none");
        timetableTemplate.setType(TimetableTemplateType.by_stop);
        
        StopModel stop1 = new StopModel();
        stop1.setId(1L);
        stop1.setName("TEST_STOP_1");
        stop1.setCity("TEST");

        StopModel stop2 = new StopModel();
        stop2.setId(2L);
        stop2.setName("TEST_STOP_2");
        stop2.setCity("TEST");

        StopModel stop3 = new StopModel();
        stop3.setId(3L);
        stop3.setName("TEST_STOP_3");
        stop3.setCity("TEST");

        RouteConnectionModel routeConnection1 = new RouteConnectionModel();
        routeConnection1.setId(1L);
        routeConnection1.setRoute(route);
        routeConnection1.setStop(stop1);
        routeConnection1.setLp(1L);
        routeConnection1.setIsOptional(0L);

        RouteConnectionModel routeConnection2 = new RouteConnectionModel();
        routeConnection2.setId(2L);
        routeConnection2.setRoute(route);
        routeConnection2.setStop(stop2);
        routeConnection2.setLp(2L);
        routeConnection2.setIsOptional(1L);

        RouteConnectionModel routeConnection3 = new RouteConnectionModel();
        routeConnection3.setId(3L);
        routeConnection3.setRoute(route);
        routeConnection3.setStop(stop3);
        routeConnection3.setLp(3L);
        routeConnection3.setIsOptional(0L);
        
        StopTimetableConfig stopTimetableConfig1 = new StopTimetableConfig();
        stopTimetableConfig1.setRoute(route);
        stopTimetableConfig1.setStop(stop1);
        stopTimetableConfig1.setTimetableTemplate(timetableTemplate);
        SingleTimetableData singleTimetableData1 = new SingleTimetableData();
        singleTimetableData1.setStop(stop1);
        singleTimetableData1.setRoute(route);
        singleTimetableData1.setRouteConnection(routeConnection1);
        singleTimetableData1.setRouteConnections(List.of(routeConnection1, routeConnection2, routeConnection3));
        singleTimetableData1.setDepartures(new DeparturesWrapper(List.of()));
        singleTimetableData1.setDestinations(List.of());
        stopTimetableConfig1.setSingleTimetableData(singleTimetableData1);
        
        StopTimetableConfig stopTimetableConfig2 = new StopTimetableConfig();
        stopTimetableConfig2.setRoute(route);
        stopTimetableConfig2.setStop(stop2);
        stopTimetableConfig2.setTimetableTemplate(timetableTemplate);
        SingleTimetableData singleTimetableData2 = new SingleTimetableData();
        singleTimetableData2.setStop(stop2);
        singleTimetableData2.setRoute(route);
        singleTimetableData2.setRouteConnection(routeConnection2);
        singleTimetableData2.setRouteConnections(List.of(routeConnection1, routeConnection2, routeConnection3));
        singleTimetableData2.setDepartures(new DeparturesWrapper(List.of()));
        singleTimetableData2.setDestinations(List.of());
        stopTimetableConfig2.setSingleTimetableData(singleTimetableData2);
        
        StopTimetableConfig stopTimetableConfig3 = new StopTimetableConfig();
        stopTimetableConfig3.setRoute(route);
        stopTimetableConfig3.setStop(stop3);
        stopTimetableConfig3.setTimetableTemplate(timetableTemplate);
        SingleTimetableData singleTimetableData3 = new SingleTimetableData();
        singleTimetableData3.setStop(stop3);
        singleTimetableData3.setRoute(route);
        singleTimetableData3.setRouteConnection(routeConnection3);
        singleTimetableData3.setRouteConnections(List.of(routeConnection1, routeConnection2, routeConnection3));
        singleTimetableData3.setDepartures(new DeparturesWrapper(List.of()));
        singleTimetableData3.setDestinations(List.of());
        stopTimetableConfig3.setSingleTimetableData(singleTimetableData3);
        
        
        RouteTimetable expectedRouteTimetable = new RouteTimetable();
        expectedRouteTimetable.setRoute(route);
        expectedRouteTimetable.setStopTimetableConfigs(List.of(stopTimetableConfig1, stopTimetableConfig2, stopTimetableConfig3));
        return expectedRouteTimetable;
    }
}
