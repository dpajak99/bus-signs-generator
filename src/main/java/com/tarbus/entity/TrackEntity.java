package com.tarbus.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tracks", schema="schedule")
public class TrackEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private RouteEntity route;

    @Column(name = "lp")
    private Long lp;

    @Column(name = "day_types")
    private String days;
}
