package com.tarbus.utils.file_naming_policy;

import com.tarbus.models.schedule.RouteModel;

import java.util.List;

public interface FileNamingPolicy {
    String getFileName(List<RouteModel> routeModels);
    
    static FileNamingPolicy fromType(FileNamingPolicyType fileNamingPolicyType) {
        return switch (fileNamingPolicyType) {
            case LineDetailsFileNamingPolicy -> new LineDetailsFileNamingPolicy();
            case ShortLineDetailsFileNamingPolicy -> new ShortLineDetailsFileNamingPolicy();
            case RouteDetailsFileNamingPolicy -> new RouteDetailsFileNamingPolicy();
            case ShortRouteDetailsFileNamingPolicy -> new ShortRouteDetailsFileNamingPolicy();
            case RouteIdFileNamingPolicy -> new RouteIdFileNamingPolicy();
            default -> throw new IllegalArgumentException("Unknown file naming policy type");
        };
    }
}
