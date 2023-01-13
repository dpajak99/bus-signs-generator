package com.tarbus.utils;

import java.util.List;

public class TimeUtils {
    public static String getFormattedTime(int timeMinutes, String format) {
        return getFormattedTime(timeMinutes, format, false);
    }
    public static String getFormattedTime(int timeMinutes, String format, boolean midnightAs24) {
        if( timeMinutes < 0 ) {
            throw new IllegalArgumentException("Time in minutes cannot be negative");
        }
        while ((midnightAs24 && timeMinutes > 1500) || (!midnightAs24 && timeMinutes > 1440)) {
            timeMinutes -= 1440;
        }
        int hours = timeMinutes / 60;
        int minutes = timeMinutes % 60;

        return switch (format) {
            case "HH:mm" -> String.format("%02d:%02d", hours, minutes);
            case "H:mm" -> String.format("%d:%02d", hours, minutes);
            case "H:" -> String.format("%d", hours);
            case "HH:" -> String.format("%02d", hours);
            case ":m" -> String.format("%d", minutes);
            case ":mm" -> String.format("%02d", minutes);
            default -> throw new IllegalArgumentException("Unsupported time format");
        };
    }
    
}
