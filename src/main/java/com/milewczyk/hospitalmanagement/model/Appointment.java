package com.milewczyk.hospitalmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "APPOINTMENTS")
public class Appointment {

    @Id
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    private LocalDateTime date;
    private String consultingOffice;

    @Lob
    private String description;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime date, String consultingOffice) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.consultingOffice = consultingOffice;
    }

    public Appointment(Patient patient, Doctor doctor, LocalDateTime date, String consultingOffice, String description) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.consultingOffice = consultingOffice;
        this.description = description;
    }
}
