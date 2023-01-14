package com.tarbus.unit.utils.file_naming_policy;

import com.tarbus.utils.file_naming_policy.LineDetailsFileNamingPolicy;

import java.util.List;

public class LineDetailsFileNamingPolicyTest extends FileNamingPolicyTest {
    
    public void testGetFileName() {
        // Arrange 
        LineDetailsFileNamingPolicy lineDetailsFileNamingPolicy = new LineDetailsFileNamingPolicy();
        
        // Act
        String actualFileName = lineDetailsFileNamingPolicy.getFileName(List.of(route1, route2));
        
        // Assert
        String expectedFileName = "A10-Krakow_A10-Tarnow";
        assertEquals(expectedFileName, actualFileName);
    }
}
