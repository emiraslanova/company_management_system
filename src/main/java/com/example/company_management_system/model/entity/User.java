package com.example.company_management_system.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
  private  Long id ;
    @Column(name = "first_name",length = 50)
    private String firstName;

    @Column(name = "last_name",length = 60)
    private String lastName;

    @Column(name = "password",length = 60)
    private String password;

    @Column(name = "e-mail")
    private String email;

    @Column(name = "birthdate")
   private Date birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

//
//  @ManyToMany(cascade = CascadeType.ALL)
//  @JoinTable(
//          name = "user_position",
//          joinColumns = @JoinColumn(name = "user_id"),
//          inverseJoinColumns = @JoinColumn(name = "position_id")
//  )
//  private List<Position> positionList;



}
