package com.tarbus.infra.services.jpa.impl;

import com.tarbus.infra.repositories.jpa.TrackRepository;
import com.tarbus.infra.services.jpa.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
}
