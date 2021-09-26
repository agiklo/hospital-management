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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Appointment appointment;

    private boolean isActive;
    private LocalDateTime validUntil;

    @OneToMany
    @JoinColumn(name = "fk_perscription")
    private List<Medicament> medicaments;

    public Prescription(Appointment appointment, LocalDateTime validUntil, List<Medicament> medicaments) {
        this.appointment = appointment;
        this.validUntil = validUntil;
        this.medicaments = medicaments;
        this.isActive = true;
    }
}
