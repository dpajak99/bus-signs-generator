package com.tarbus.utils.file_naming_policy;

import com.tarbus.models.schedule.RouteModel;

import java.util.List;

public class RouteDetailsFileNamingPolicy implements FileNamingPolicy {
    @Override
    public String getFileName(List<RouteModel> routeModels) {
        if (routeModels.size() == 1) {
            return routeModels.get(0).getId() + "-" + routeModels.get(0).getName();
        }
        StringBuilder fileName = new StringBuilder();
        for (int i = 0; i < routeModels.size(); i++) {
            RouteModel routeModel = routeModels.get(i);
            fileName.append(routeModel.getId()).append("-").append(routeModel.getName());
            if (i != routeModels.size() - 1) {
                fileName.append("_");
            }
        }
        return fileName.toString();
    }
}
