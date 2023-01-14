package com.tarbus.unit.utils.file_naming_policy;

import com.tarbus.utils.file_naming_policy.ShortRouteDetailsFileNamingPolicy;

import java.util.List;

public class ShortRouteDetailsFileNamingPolicyTest extends FileNamingPolicyTest {
    
    public void testGetFileName() {
        // Arrange 
        ShortRouteDetailsFileNamingPolicy shortRouteDetailsFileNamingPolicy = new ShortRouteDetailsFileNamingPolicy();
        
        // Act
        String actualFileName = shortRouteDetailsFileNamingPolicy.getFileName(List.of(route1, route2));
        
        // Assert
        String expectedFileName = "1-Kra_2-Tar";
        assertEquals(expectedFileName, actualFileName);
    }
}
