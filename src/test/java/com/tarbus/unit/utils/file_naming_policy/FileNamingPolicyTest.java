package com.tarbus.unit.utils.file_naming_policy;

import com.tarbus.models.schedule.LineModel;
import com.tarbus.models.schedule.RouteModel;
import junit.framework.TestCase;

public abstract class FileNamingPolicyTest extends TestCase {
    protected RouteModel route1 = new RouteModel();
    protected RouteModel route2 = new RouteModel();

    public FileNamingPolicyTest() {
        LineModel lineModel = new LineModel();
        lineModel.setId(1L);
        lineModel.setName("A10");
        route1.setId(1L);
        route1.setName("Krakow");
        route1.setLine(lineModel);
        route2.setId(2L);
        route2.setName("Tarnow");
        route2.setLine(lineModel);
    }
}
