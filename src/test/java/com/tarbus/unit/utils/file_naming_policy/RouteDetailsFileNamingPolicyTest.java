package com.tarbus.unit.utils.file_naming_policy;

import com.tarbus.utils.file_naming_policy.RouteDetailsFileNamingPolicy;

import java.util.List;

public class RouteDetailsFileNamingPolicyTest extends FileNamingPolicyTest {
    
    public void testGetFileName() {
        // Arrange 
        RouteDetailsFileNamingPolicy routeDetailsFileNamingPolicy = new RouteDetailsFileNamingPolicy();
        
        // Act
        String actualFileName = routeDetailsFileNamingPolicy.getFileName(List.of(route1, route2));
        
        // Assert
        String expectedFileName = "1-Krakow_2-Tarnow";
        assertEquals(expectedFileName, actualFileName);
    }
}
