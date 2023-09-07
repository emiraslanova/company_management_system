package com.example.company_management_system.model.mapper;

import com.example.company_management_system.model.dto.CompanyDTO;
import com.example.company_management_system.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mapping(target = "userList", ignore = true)
    Company toEntity(CompanyDTO companyDTO);

    @Mapping(target = "employeeCount", expression = "java(employeeCount())")
    CompanyDTO toDto(Company company);

    default int employeeCount() {
        return 50;
    }
}



