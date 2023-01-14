package com.tarbus.services.jpa.impl;

import com.tarbus.repositories.jpa.LineRepository;
import com.tarbus.services.jpa.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineServiceImpl implements LineService {
    private LineRepository lineRepository;

    @Autowired
    public LineServiceImpl(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }
}
