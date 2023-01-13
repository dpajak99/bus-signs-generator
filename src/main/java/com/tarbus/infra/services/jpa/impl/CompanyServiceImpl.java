package com.tarbus.infra.services.jpa.impl;

import com.tarbus.infra.repositories.jpa.CompanyRepository;
import com.tarbus.infra.services.jpa.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
