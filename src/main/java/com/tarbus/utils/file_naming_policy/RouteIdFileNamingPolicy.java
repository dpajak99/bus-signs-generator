package com.tarbus.utils.file_naming_policy;

import com.tarbus.models.schedule.RouteModel;

import java.util.List;

public class RouteIdFileNamingPolicy implements FileNamingPolicy {
    @Override
    public String getFileName(List<RouteModel> routeModels) {
        if(routeModels.size() == 1) {
            return routeModels.get(0).getId().toString();
        }
        return routeModels.stream().map(RouteModel::getId).map(Object::toString).reduce((s, s2) -> s + "_" + s2).orElse("");
    }
}