package com.tarbus.integration;

import com.tarbus.utils.TimetableTemplateResolver;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TimetableTimetableTemplateResolverIntegrationTestContent extends TestCase {

    public void testResolveBaseFile1() throws IOException {
        // Arrange
        String fileName = "header";
        Map<String, Object> variables = Map.of(
                "title", "Random title",
                "timetableTemplates", List.of("test_template_1")
        );

        // Act
        String actualResolverResult = TimetableTemplateResolver.resolveBaseFile(fileName, variables);

        // Assert
        String expectedResolverResult = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Random title</title>
                   \s
                    <link rel="stylesheet" href="./test_template_1/style.css">
                </head>
                <body>""";
        assertEquals(expectedResolverResult, actualResolverResult);
    }
    
    public void testResolveBaseFile2() throws IOException {
        // Arrange
        String fileName = "header";
        Map<String, Object> variables = Map.of(
                "title", "Timetables",
                "timetableTemplates", List.of("test_template_1", "test_template_2")
        );
        
        // Act
        String actualResolverResult = TimetableTemplateResolver.resolveBaseFile(fileName, variables);
        
        // Assert
        String expectedResolverResult = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Timetables</title>
                   \s
                    <link rel="stylesheet" href="./test_template_1/style.css"><link rel="stylesheet" href="./test_template_2/style.css">
                </head>
                <body>""";
        assertEquals(expectedResolverResult, actualResolverResult);
    }

    public void testResolveTemplateFile1() throws IOException {
        // Arrange
        String fileName = "test_template_1";
        Map<String, Object> variables = Map.of();

        // Act
        String actualResolverResult = TimetableTemplateResolver.resolveTemplateFile(fileName, variables);

        // Assert
        String expectedResolverResult = """
                <div class="wrapper">
                    <h1>TEST TEMPLATE 1</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div>""";
        assertEquals(expectedResolverResult, actualResolverResult);
    }

    public void testResolveTemplateFile2() throws IOException {
        // Arrange
        String fileName = "test_template_2";
        Map<String, Object> variables = Map.of();

        // Act
        String actualResolverResult = TimetableTemplateResolver.resolveTemplateFile(fileName, variables);

        // Assert
        String expectedResolverResult = """
                <div class="wrapper">
                    <h1>TEST TEMPLATE 2</h1>
                    <div style="float: left; height: 100px; width: 100px; background: red;"></div>
                    <div style="float: right; height: 100px; width: 100px;  background: green;"></div>
                </div>""";
        assertEquals(expectedResolverResult, actualResolverResult);
    }
}
