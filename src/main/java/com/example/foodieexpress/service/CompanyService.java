package com.example.foodieexpress.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
    public class CompanyService {

        private final CompanyRepository companyRepository;


        public List<Company> findCompaniesByIds(List<Long> companyIds) {
            return companyRepository.findAllById(companyIds);
        }
    }

