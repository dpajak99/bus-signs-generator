package com.tarbus.utils.file_naming_policy;

import com.tarbus.models.schedule.RouteModel;

import java.util.List;

public class LineDetailsFileNamingPolicy implements FileNamingPolicy {
    @Override
    public String getFileName(List<RouteModel> routeModels) {
        if (routeModels.size() == 1) {
            return routeModels.get(0).getLine().getName() + "-" + routeModels.get(0).getName();
        }
        StringBuilder fileName = new StringBuilder();
        for (int i = 0; i < routeModels.size(); i++) {
            RouteModel routeModel = routeModels.get(i);
            fileName.append(routeModel.getLine().getName()).append("-").append(routeModel.getName());
            if (i != routeModels.size() - 1) {
                fileName.append("_");
            }
        }
        return fileName.toString();
    }
}
