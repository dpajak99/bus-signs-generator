package com.tarbus.services.jpa.impl;

import com.tarbus.repositories.jpa.TimetableVersionRepository;
import com.tarbus.services.jpa.TimetableVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableVersionServiceImpl implements TimetableVersionService {
    private TimetableVersionRepository timetableVersionRepository;

    @Autowired
    public TimetableVersionServiceImpl(TimetableVersionRepository timetableVersionRepository) {
        this.timetableVersionRepository = timetableVersionRepository;
    }
}
