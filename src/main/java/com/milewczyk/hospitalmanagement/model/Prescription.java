package com.milewczyk.hospitalmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRESCRIPTIONS")
public class Prescription {

    @Id
    private Long id;

    @OneToOne
    private Appointment appointment;

    private boolean used;
    private LocalDateTime validUntil;

    @OneToMany
    private List<Medicament> medicaments;

    public Prescription(Appointment appointment, boolean used, LocalDateTime validUntil, List<Medicament> medicaments) {
        this.appointment = appointment;
        this.used = used;
        this.validUntil = validUntil;
        this.medicaments = medicaments;
    }
}
