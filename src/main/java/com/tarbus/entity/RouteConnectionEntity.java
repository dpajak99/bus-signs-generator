package com.tarbus.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "routes_connections", schema = "schedule")
public class RouteConnectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private RouteEntity route;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "bus_stop_id", referencedColumnName = "id")
    private StopEntity stop;

    @Column(name = "is_optional")
    private Long isOptional;
    
    @Column(name = "lp")
    private Long lp;

    @Column(name = "description")
    private String description;
}
