package com.milewczyk.hospitalmanagement.model.dto;

import com.milewczyk.hospitalmanagement.enums.SEX;
import com.milewczyk.hospitalmanagement.enums.SPECIALIST;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientViewOfDoctorDTO {

    private String firstname;
    private String lastname;
    private String nationality;
    private LocalDateTime dateOfBirth;
    private SEX sex;
    private SPECIALIST specialist;
    private String phoneNumber;
    private String email;
}
