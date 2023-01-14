package com.tarbus.models.timetable_data;

import com.tarbus.entity.StopEntity;
import com.tarbus.models.schedule.StopModel;

public interface TimetableData {
    boolean isStopOnRequest();
    StopModel getStop();
}
