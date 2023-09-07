package com.example.company_management_system.model.entity;

import com.example.company_management_system.util.LocalDateConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 255)
    private String name;

   @Convert(converter = LocalDateConverter.class)
    @Column(name = "create_date")
    private LocalDate createDate;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<User> userList;


}
