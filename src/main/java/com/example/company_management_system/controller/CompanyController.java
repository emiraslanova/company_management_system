package com.example.company_management_system.controller;

import com.example.company_management_system.model.dto.CompanyDTO;
import com.example.company_management_system.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creatCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        System.out.println(companyDTO.getCreateDate() + " -----------");
        companyService.creatCompany(companyDTO);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> readAllCompany() {
        return companyService.readAllCompany();
    }

    @GetMapping("/{id}")
    public ResponseEntity readByIdCompany(@PathVariable(name = "id") Long id) {
        return companyService.readByIdCompany(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity updateCompanyById(@Valid @RequestBody CompanyDTO companyDTO, @PathVariable Long id) {
        return companyService.updateCompanyById(companyDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompanyById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
    }
}
