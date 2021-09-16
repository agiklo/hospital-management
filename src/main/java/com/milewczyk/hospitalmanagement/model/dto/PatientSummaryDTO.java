package com.milewczyk.hospitalmanagement.model.dto;

import com.milewczyk.hospitalmanagement.enums.SEX;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientSummaryDTO {

    private String firstname;
    private String lastname;
    private String phoneNumber;
    private SEX sex;

}
