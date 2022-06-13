package com.example.crmpointprojectv1.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "customer")
@RequiredArgsConstructor
public class Customer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "First Name is mandatory")
    @Size(min=2, max=30)
    private String firstName;

    @Column
    @NotBlank(message = "Last Name is mandatory")
    @Size(min=2, max=30)
    private String lastName;

    @NotBlank(message = "Email Address is mandatory")
    @Size(min=4, max=30)
    private String emailAddress;

    @NotBlank(message = "Address is mandatory")
    @Size(min=5, max=30)
    private String address;

    @NotBlank(message = "City is mandatory")
    @Size(min=2, max=30)
    private String city;

    @NotBlank(message = "Country is mandatory")
    @Size(min=2, max=30)
    private String country;

    @NotBlank(message = "Phone Number is mandatory")
    @Size(min=5, max=15)
    private String phoneNumber;

    @NotBlank(message = "Company is mandatory")
    @Size(min=2, max=10)
    private String company;

}
