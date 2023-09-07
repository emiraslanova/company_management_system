package com.example.company_management_system.service.impl;

import com.example.company_management_system.model.dto.CompanyDTO;
import com.example.company_management_system.model.entity.Company;
import com.example.company_management_system.exception.NotFoundException;
import com.example.company_management_system.model.mapper.CompanyMapper;
import com.example.company_management_system.repository.CompanyRepository;
import com.example.company_management_system.service.CompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public void creatCompany(CompanyDTO companyDTO) {
        companyRepository.save(companyMapper.toEntity(companyDTO));
    }

    @Transactional
    @Override
    public ResponseEntity<List<CompanyDTO>> readAllCompany() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDTO> companyDTOs = companies.stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(companyDTOs);
    }

    @Override
    public ResponseEntity readByIdCompany(long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Company not found with id: " + id));
        return ResponseEntity.ok(companyMapper.toDto(company));
    }

    @Override
    public ResponseEntity updateCompanyById(CompanyDTO companyDTO, long id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Company not found with id: " + id));

        company.setName(companyDTO.getName());
 //    company.setCreateDate(companyDTO.getCreateDate());
        company.setCreateDate(companyDTO.getCreateDate());
        company = companyRepository.save(company);
        return ResponseEntity.ok(companyMapper.toDto(company));
    }

    @Override
    public void deleteCompanyById(long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Company not found with id: " + id));

        companyRepository.delete(company);
    }

}

