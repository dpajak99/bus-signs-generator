package com.tarbus.infra.services.jpa.impl;

import com.tarbus.infra.repositories.jpa.LineRepository;
import com.tarbus.infra.services.jpa.LineService;
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
