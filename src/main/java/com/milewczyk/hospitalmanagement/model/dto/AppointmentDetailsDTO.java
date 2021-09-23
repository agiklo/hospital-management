package com.milewczyk.hospitalmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDetailsDTO {

    private String doctorFirstname;
    private String doctorLastname;
    private String patientFirstname;
    private String patientLastname;
    private String description;
    private LocalDateTime date;
    private String consultingOffice;
}
