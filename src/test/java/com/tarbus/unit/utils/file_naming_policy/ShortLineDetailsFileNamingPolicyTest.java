package com.tarbus.unit.utils.file_naming_policy;

import com.tarbus.utils.file_naming_policy.LineDetailsFileNamingPolicy;
import com.tarbus.utils.file_naming_policy.ShortLineDetailsFileNamingPolicy;

import java.util.List;

public class ShortLineDetailsFileNamingPolicyTest extends FileNamingPolicyTest {
    
    public void testGetFileName() {
        // Arrange 
        ShortLineDetailsFileNamingPolicy shortLineDetailsFileNamingPolicy = new ShortLineDetailsFileNamingPolicy();
        
        // Act
        String actualFileName = shortLineDetailsFileNamingPolicy.getFileName(List.of(route1, route2));
        
        // Assert
        String expectedFileName = "A10-Kra_A10-Tar";
        assertEquals(expectedFileName, actualFileName);
    }
}
