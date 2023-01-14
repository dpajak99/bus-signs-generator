package com.tarbus.unit.utils.file_naming_policy;

import com.tarbus.utils.file_naming_policy.RouteDetailsFileNamingPolicy;
import com.tarbus.utils.file_naming_policy.RouteIdFileNamingPolicy;
import com.tarbus.utils.file_naming_policy.ShortRouteDetailsFileNamingPolicy;

import java.util.List;

public class RouteIdFileNamingPolicyTest extends FileNamingPolicyTest {
    
    public void testGetFileName() {
        // Arrange 
        RouteIdFileNamingPolicy routeIdFileNamingPolicy = new RouteIdFileNamingPolicy();
        
        // Act
        String actualFileName = routeIdFileNamingPolicy.getFileName(List.of(route1, route2));
        
        // Assert
        String expectedFileName = "1_2";
        assertEquals(expectedFileName, actualFileName);
    }
}
