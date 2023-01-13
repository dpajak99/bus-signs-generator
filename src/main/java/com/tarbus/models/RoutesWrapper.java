package com.tarbus.models;

import com.tarbus.models.schedule.RouteModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class RoutesWrapper {
    private List<RouteModel> routeModels;

    public RoutesWrapper(List<RouteModel> routeModels) {
        routeModels.sort(Comparator.comparing(RouteModel::getId));
        this.routeModels = routeModels;
    }

    public int size() {
        return routeModels.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoutesWrapper that)) return false;

        return Objects.equals(routeModels, that.routeModels);
    }

    @Override
    public int hashCode() {
        return routeModels != null ? routeModels.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RoutesWrapper{" +
                "routeModels=" + routeModels +
                '}';
    }
}