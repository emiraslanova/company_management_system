package com.example.company_management_system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@Component
@NoArgsConstructor
public class CompanyDTO {

    private Long id;

    private String name;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate createDate;

    private int employeeCount;

}
