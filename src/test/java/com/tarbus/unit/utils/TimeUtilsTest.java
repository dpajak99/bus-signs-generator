package com.tarbus.unit.utils;

import com.tarbus.utils.TimeUtils;
import junit.framework.TestCase;

public class TimeUtilsTest extends TestCase {
    public void testGetFormattedTime_HH_mm_1() {
        // Arrange
        int timeInMinutes = 0;
        String format = "HH:mm";
        
        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);
        
        // Assert
        String expectedTimeString = "00:00";
        
        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_HH_mm_2() {
        // Arrange
        int timeInMinutes = 541;
        String format = "HH:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "09:01";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_HH_mm_3() {
        // Arrange
        int timeInMinutes = 6289;
        String format = "HH:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "08:49";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_HH_mm_4() {
        // Arrange
        int timeInMinutes = 1003;
        String format = "HH:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "16:43";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_HH_mm_5() {
        // Arrange
        int timeInMinutes = 1445;
        String format = "HH:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "00:05";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_HH_mm_6() {
        // Arrange
        int timeInMinutes = 1445;
        String format = "HH:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format, true);

        // Assert
        String expectedTimeString = "24:05";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_mm_1() {
        // Arrange
        int timeInMinutes = 0;
        String format = "H:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "0:00";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_mm_2() {
        // Arrange
        int timeInMinutes = 541;
        String format = "H:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "9:01";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_mm_3() {
        // Arrange
        int timeInMinutes = 6289;
        String format = "H:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "8:49";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_mm_4() {
        // Arrange
        int timeInMinutes = 1003;
        String format = "H:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "16:43";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_mm_5() {
        // Arrange
        int timeInMinutes = 1445;
        String format = "H:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "0:05";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_mm_6() {
        // Arrange
        int timeInMinutes = 1445;
        String format = "H:mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format, true);

        // Assert
        String expectedTimeString = "24:05";

        assertEquals(expectedTimeString, actualTimeString);
    }
    
    public void testGetFormattedTime_HH_1() {
        // Arrange
        int timeInMinutes = 0;
        String format = "HH:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "00";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_HH_2() {
        // Arrange
        int timeInMinutes = 541;
        String format = "HH:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "09";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_HH_3() {
        // Arrange
        int timeInMinutes = 6289;
        String format = "HH:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "08";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_HH_4() {
        // Arrange
        int timeInMinutes = 1003;
        String format = "HH:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "16";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_HH_5() {
        // Arrange
        int timeInMinutes = 1445;
        String format = "HH:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "00";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_HH_6() {
        // Arrange
        int timeInMinutes = 1445;
        String format = "HH:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format, true);

        // Assert
        String expectedTimeString = "24";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_1() {
        // Arrange
        int timeInMinutes = 0;
        String format = "H:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "0";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_2() {
        // Arrange
        int timeInMinutes = 541;
        String format = "H:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "9";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_3() {
        // Arrange
        int timeInMinutes = 6289;
        String format = "H:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "8";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_4() {
        // Arrange
        int timeInMinutes = 1003;
        String format = "H:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "16";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_5() {
        // Arrange
        int timeInMinutes = 1445;
        String format = "H:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "0";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_H_6() {
        // Arrange
        int timeInMinutes = 1445;
        String format = "H:";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format, true);

        // Assert
        String expectedTimeString = "24";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_mm_1() {
        // Arrange
        int timeInMinutes = 0;
        String format = ":mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "00";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_mm_2() {
        // Arrange
        int timeInMinutes = 541;
        String format = ":mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "01";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_mm_3() {
        // Arrange
        int timeInMinutes = 6289;
        String format = ":mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "49";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_mm_4() {
        // Arrange
        int timeInMinutes = 1003;
        String format = ":mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "43";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_mm_5() {
        // Arrange
        int timeInMinutes = 1445;
        String format = ":mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "05";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_mm_6() {
        // Arrange
        int timeInMinutes = 1445;
        String format = ":mm";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format, true);

        // Assert
        String expectedTimeString = "05";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_m_1() {
        // Arrange
        int timeInMinutes = 0;
        String format = ":m";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "0";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_m_2() {
        // Arrange
        int timeInMinutes = 541;
        String format = ":m";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "1";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_m_3() {
        // Arrange
        int timeInMinutes = 6289;
        String format = ":m";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "49";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_m_4() {
        // Arrange
        int timeInMinutes = 1003;
        String format = ":m";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "43";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_m_5() {
        // Arrange
        int timeInMinutes = 1445;
        String format = ":m";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format);

        // Assert
        String expectedTimeString = "5";

        assertEquals(expectedTimeString, actualTimeString);
    }

    public void testGetFormattedTime_m_6() {
        // Arrange
        int timeInMinutes = 1445;
        String format = ":m";

        // Act
        String actualTimeString = TimeUtils.getFormattedTime(timeInMinutes, format, true);

        // Assert
        String expectedTimeString = "5";

        assertEquals(expectedTimeString, actualTimeString);
    }
}
