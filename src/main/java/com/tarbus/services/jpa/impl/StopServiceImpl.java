package com.tarbus.services.jpa.impl;

import com.tarbus.repositories.jpa.StopRepository;
import com.tarbus.services.jpa.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopServiceImpl implements StopService {
    private StopRepository stopRepository;

    @Autowired
    public StopServiceImpl(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }
}
