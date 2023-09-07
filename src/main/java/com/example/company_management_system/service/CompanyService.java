package com.example.company_management_system.service;

import com.example.company_management_system.model.dto.CompanyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    void creatCompany(CompanyDTO companyDTO);

    ResponseEntity<List<CompanyDTO>> readAllCompany();

    ResponseEntity readByIdCompany(long id);

    ResponseEntity updateCompanyById(CompanyDTO companyDTO, long id);

    void deleteCompanyById(long id);
}
