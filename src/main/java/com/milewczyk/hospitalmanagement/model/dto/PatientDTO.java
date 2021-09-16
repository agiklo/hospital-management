package com.milewczyk.hospitalmanagement.model.dto;

import com.milewczyk.hospitalmanagement.enums.BLOOD_GROUP;
import com.milewczyk.hospitalmanagement.enums.RELATIONSHIP;
import com.milewczyk.hospitalmanagement.enums.SEX;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private String firstname;
    private String lastname;
    private LocalDateTime dateOfBirth;
    private SEX sex;
    private Double height;
    private Double weight;
    private BLOOD_GROUP bloodGroup;
    private RELATIONSHIP relationship;
    private String nationality;
    private String phoneNumber;
    private String email;
    private String city;
    private String street;
    private String streetNumber;
    private String apartmentNumber;
    private String postCode;
    private String country;
}
