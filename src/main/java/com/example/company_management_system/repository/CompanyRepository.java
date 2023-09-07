package com.example.company_management_system.repository;

import com.example.company_management_system.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository  extends JpaRepository<Company,Long> {

}
