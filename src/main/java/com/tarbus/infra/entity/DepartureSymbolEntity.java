package com.tarbus.infra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "destinations", schema = "schedule")
public class DepartureSymbolEntity {
    @EmbeddedId
    private DepartureSymbolEntityId id;
    @Column(name = "direction_board_name")
    private String boardName;

    @Column(name = "schedule_name")
    private String scheduleName;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    public static class DepartureSymbolEntityId implements Serializable {
        @OneToOne(cascade = CascadeType.REMOVE)
        @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = false)
        private RouteEntity route;

        @Column(name = "symbol")
        private String symbols;
    }
}
