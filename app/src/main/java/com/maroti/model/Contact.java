package com.maroti.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {
    private Integer id;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String description;
    private String street;
    private String city;
    private String state;
    private String postCode;
    private String country;
    private String phone;
    private String dept;


}
