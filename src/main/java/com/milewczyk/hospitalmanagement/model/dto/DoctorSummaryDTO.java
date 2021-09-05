package com.milewczyk.hospitalmanagement.model.dto;

import com.milewczyk.hospitalmanagement.enums.SPECIALIST;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSummaryDTO {

    private String firstname;
    private String lastname;
    private SPECIALIST specialist;
    private String phoneNumber;
    private String email;
}
