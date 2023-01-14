package com.tarbus.integration.models;

import com.tarbus.Application;
import com.tarbus.config.H2TestProfileJPAConfig;
import com.tarbus.services.generator.TimetableService;
import com.tarbus.models.RouteTimetable;
import com.tarbus.models.StopTimetableConfig;
import com.tarbus.models.TimetablePageStructure;
import com.tarbus.models.schedule.RouteModel;
import com.tarbus.models.timetable_template_content.MultiTimetableTemplateContent;
import com.tarbus.models.timetable_template_content.SingleTimetableTemplateContent;
import com.tarbus.models.timetable_template_content.TimetableTemplateContent;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        Application.class,
        H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class TimetablePageStructureIntegrationTest extends TestCase {
    @Autowired
    private TimetableService timetableService;
    
    
    @Test
    public void testAddMethod() {
        // Arrange
        RouteTimetable routeTimetable1 = timetableService.getRouteTimetableByRouteId(1L);
        RouteTimetable routeTimetable2 = timetableService.getRouteTimetableByRouteId(2L);
        RouteTimetable routeTimetable3 = timetableService.getRouteTimetableByRouteId(3L);
        RouteTimetable routeTimetable4 = timetableService.getRouteTimetableByRouteId(4L);

        StopTimetableConfig stopTimetableConfig1 = routeTimetable1.getStopTimetableConfigs().get(0);
        StopTimetableConfig stopTimetableConfig3 = routeTimetable3.getStopTimetableConfigs().get(0);
        StopTimetableConfig stopTimetableConfig2 = routeTimetable2.getStopTimetableConfigs().get(2);
        StopTimetableConfig stopTimetableConfig4 = routeTimetable4.getStopTimetableConfigs().get(2);

        // Act
        TimetablePageStructure actualTimetablePageStructure = new TimetablePageStructure();
        actualTimetablePageStructure.add(stopTimetableConfig1.getTimetableTemplate(), stopTimetableConfig1.getSingleTimetableData());
        
        // Assert
        List<TimetableTemplateContent> expectedTimetableTemplateContent = new ArrayList<>();
        expectedTimetableTemplateContent.add(new SingleTimetableTemplateContent(stopTimetableConfig1.getTimetableTemplate(), stopTimetableConfig1.getSingleTimetableData(), routeTimetable1.getRoute()));
        
        TimetablePageStructure expectedTimetablePageStructure = new TimetablePageStructure();
        expectedTimetablePageStructure.setStructure(expectedTimetableTemplateContent);
        
        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);
        
        // Act
        actualTimetablePageStructure.add(stopTimetableConfig2.getTimetableTemplate(), stopTimetableConfig2.getSingleTimetableData());
        
        // Assert
        expectedTimetableTemplateContent.add(new SingleTimetableTemplateContent(stopTimetableConfig2.getTimetableTemplate(), stopTimetableConfig2.getSingleTimetableData(), routeTimetable2.getRoute()));
        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);
        
        // Act
        actualTimetablePageStructure.add(stopTimetableConfig3.getTimetableTemplate(), stopTimetableConfig3.getSingleTimetableData());
        
        // Assert
        expectedTimetableTemplateContent.add(new MultiTimetableTemplateContent(stopTimetableConfig3.getTimetableTemplate(), List.of(stopTimetableConfig3.getSingleTimetableData()), List.of(routeTimetable3.getRoute())));

        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);
        
        // Act
        actualTimetablePageStructure.add(stopTimetableConfig4.getTimetableTemplate(), stopTimetableConfig4.getSingleTimetableData());

        // Assert
        expectedTimetableTemplateContent.remove(expectedTimetableTemplateContent.size() - 1);
        expectedTimetableTemplateContent.add(new MultiTimetableTemplateContent(stopTimetableConfig3.getTimetableTemplate(), List.of(stopTimetableConfig3.getSingleTimetableData(), stopTimetableConfig4.getSingleTimetableData()), List.of(routeTimetable3.getRoute(), routeTimetable4.getRoute())));

        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);
    }

    @Test
    public void testGetPageRoutes() {
        // Arrange
        RouteTimetable routeTimetable1 = timetableService.getRouteTimetableByRouteId(1L);
        RouteTimetable routeTimetable2 = timetableService.getRouteTimetableByRouteId(2L);
        RouteTimetable routeTimetable3 = timetableService.getRouteTimetableByRouteId(3L);
        RouteTimetable routeTimetable4 = timetableService.getRouteTimetableByRouteId(4L);

        StopTimetableConfig stopTimetableConfig1 = routeTimetable1.getStopTimetableConfigs().get(0);
        StopTimetableConfig stopTimetableConfig3 = routeTimetable3.getStopTimetableConfigs().get(0);
        StopTimetableConfig stopTimetableConfig2 = routeTimetable2.getStopTimetableConfigs().get(2);
        StopTimetableConfig stopTimetableConfig4 = routeTimetable4.getStopTimetableConfigs().get(2);

        TimetablePageStructure timetablePageStructure = new TimetablePageStructure();;

        // Act
        timetablePageStructure.add(stopTimetableConfig1.getTimetableTemplate(), stopTimetableConfig1.getSingleTimetableData());
        List<RouteModel> actualPageRoutes = timetablePageStructure.getPageRoutes();

        // Assert
        List<RouteModel> expectedPageRoutes = List.of(routeTimetable1.getRoute());
        assertEquals(expectedPageRoutes, actualPageRoutes);
        
        // Act
        timetablePageStructure.add(stopTimetableConfig2.getTimetableTemplate(), stopTimetableConfig2.getSingleTimetableData());
        actualPageRoutes = timetablePageStructure.getPageRoutes();

        // Assert
        expectedPageRoutes = List.of(routeTimetable1.getRoute(), routeTimetable2.getRoute());
        assertEquals(expectedPageRoutes, actualPageRoutes);

        // Act
        timetablePageStructure.add(stopTimetableConfig3.getTimetableTemplate(), stopTimetableConfig3.getSingleTimetableData());
        actualPageRoutes = timetablePageStructure.getPageRoutes();

        // Assert
        expectedPageRoutes = List.of(routeTimetable1.getRoute(), routeTimetable2.getRoute(), routeTimetable3.getRoute());
        assertEquals(expectedPageRoutes, actualPageRoutes);

        // Act
        timetablePageStructure.add(stopTimetableConfig4.getTimetableTemplate(), stopTimetableConfig4.getSingleTimetableData());
        actualPageRoutes = timetablePageStructure.getPageRoutes();

        // Assert
        expectedPageRoutes = List.of(routeTimetable1.getRoute(), routeTimetable2.getRoute(), routeTimetable3.getRoute(), routeTimetable4.getRoute());
        assertEquals(expectedPageRoutes, actualPageRoutes);
    }

    @Test
    public void testBuildHtml() throws IOException {
        // Arrange
        RouteTimetable routeTimetable1 = timetableService.getRouteTimetableByRouteId(1L);
        RouteTimetable routeTimetable2 = timetableService.getRouteTimetableByRouteId(2L);
        RouteTimetable routeTimetable3 = timetableService.getRouteTimetableByRouteId(3L);
        RouteTimetable routeTimetable4 = timetableService.getRouteTimetableByRouteId(4L);

        StopTimetableConfig stopTimetableConfig1 = routeTimetable1.getStopTimetableConfigs().get(0);
        StopTimetableConfig stopTimetableConfig3 = routeTimetable3.getStopTimetableConfigs().get(0);
        StopTimetableConfig stopTimetableConfig2 = routeTimetable2.getStopTimetableConfigs().get(2);
        StopTimetableConfig stopTimetableConfig4 = routeTimetable4.getStopTimetableConfigs().get(2);

        TimetablePageStructure timetablePageStructure = new TimetablePageStructure();;

        // Act
        timetablePageStructure.add(stopTimetableConfig1.getTimetableTemplate(), stopTimetableConfig1.getSingleTimetableData());
        String actualHtml = timetablePageStructure.buildHtml();

        // Assert
        String expectedHtml = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Timetables</title>
                   \s
                    <link rel="stylesheet" href="./test_template_1/style.css">
                </head>
                <body><div class="wrapper">
                    <h1>TEST TEMPLATE 1</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div></body></html>""";
        assertEquals(expectedHtml, actualHtml);

        // Act
        timetablePageStructure.add(stopTimetableConfig2.getTimetableTemplate(), stopTimetableConfig2.getSingleTimetableData());
        actualHtml = timetablePageStructure.buildHtml();

        // Assert
        expectedHtml = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Timetables</title>
                   \s
                    <link rel="stylesheet" href="./test_template_1/style.css"><link rel="stylesheet" href="./test_template_1/style.css">
                </head>
                <body><div class="wrapper">
                    <h1>TEST TEMPLATE 1</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div><div class="wrapper">
                    <h1>TEST TEMPLATE 1</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div></body></html>""";
        assertEquals(expectedHtml, actualHtml);

        // Act
        timetablePageStructure.add(stopTimetableConfig3.getTimetableTemplate(), stopTimetableConfig3.getSingleTimetableData());
        actualHtml = timetablePageStructure.buildHtml();

        // Assert
        expectedHtml = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Timetables</title>
                   \s
                    <link rel="stylesheet" href="./test_template_1/style.css"><link rel="stylesheet" href="./test_template_1/style.css"><link rel="stylesheet" href="./test_template_2/style.css">
                </head>
                <body><div class="wrapper">
                    <h1>TEST TEMPLATE 1</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div><div class="wrapper">
                    <h1>TEST TEMPLATE 1</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div><div class="wrapper">
                    <h1>TEST TEMPLATE 2</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div></body></html>""";
        assertEquals(expectedHtml, actualHtml);

        // Act
        timetablePageStructure.add(stopTimetableConfig4.getTimetableTemplate(), stopTimetableConfig4.getSingleTimetableData());
        actualHtml = timetablePageStructure.buildHtml();

        // Assert
        expectedHtml = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Timetables</title>
                   \s
                    <link rel="stylesheet" href="./test_template_1/style.css"><link rel="stylesheet" href="./test_template_1/style.css"><link rel="stylesheet" href="./test_template_2/style.css">
                </head>
                <body><div class="wrapper">
                    <h1>TEST TEMPLATE 1</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div><div class="wrapper">
                    <h1>TEST TEMPLATE 1</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div><div class="wrapper">
                    <h1>TEST TEMPLATE 2</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div></body></html>""";
        assertEquals(expectedHtml, actualHtml);
    }
}
