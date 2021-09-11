package com.milewczyk.hospitalmanagement.model.dto;

import com.milewczyk.hospitalmanagement.enums.SEX;
import com.milewczyk.hospitalmanagement.enums.SPECIALIST;
import com.milewczyk.hospitalmanagement.model.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminViewOfDoctorDTO {

    private String firstname;
    private String lastname;
    private String nationality;
    private LocalDateTime dateOfBirth;
    private SEX sex;
    private String city;
    private String street;
    private String streetNumber;
    private String apartmentNumber;
    private String postCode;
    private String country;
    private SPECIALIST specialist;
    private String phoneNumber;
    private String email;
    private List<Appointment> appointments;
}
