package com.milewczyk.hospitalmanagement.model;

import com.milewczyk.hospitalmanagement.enums.BLOOD_GROUP;
import com.milewczyk.hospitalmanagement.enums.RELATIONSHIP;
import com.milewczyk.hospitalmanagement.enums.SEX;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "PATIENTS")
public class Patient extends User {

    @Id
    private Long id;

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private RELATIONSHIP relationship;

    private Double height;
    private Double weight;

    @Enumerated(EnumType.STRING)
    private BLOOD_GROUP bloodGroup;

    @OneToOne
    private Relative relative;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

    public Patient(String firstname,
                   String lastname,
                   String phoneNumber,
                   String email,
                   String nationality,
                   LocalDateTime dateOfBirth,
                   SEX sex,
                   Address address,
                   RELATIONSHIP relationship,
                   Double height,
                   Double weight,
                   BLOOD_GROUP bloodGroup,
                   Relative relative,
                   List<Appointment> appointments,
                   List<Prescription> prescriptions) {
        super(firstname, lastname, phoneNumber, email, nationality, dateOfBirth, sex);
        this.address = address;
        this.relationship = relationship;
        this.height = height;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        this.relative = relative;
        this.appointments = appointments;
        this.prescriptions = prescriptions;
    }
}
