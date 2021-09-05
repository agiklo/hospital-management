package com.milewczyk.hospitalmanagement.model;

import com.milewczyk.hospitalmanagement.enums.SEX;
import com.milewczyk.hospitalmanagement.enums.SPECIALIST;
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
@Table(name = "DOCTORS")
public class Doctor extends User {

    @Id
    private Long id;

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private SPECIALIST specialist;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    public Doctor(String firstname,
                  String lastname,
                  String phoneNumber,
                  String email,
                  String nationality,
                  LocalDateTime dateOfBirth,
                  SEX sex,
                  Address address,
                  SPECIALIST specialist,
                  List<Appointment> appointments) {
        super(firstname, lastname, phoneNumber, email, nationality, dateOfBirth, sex);
        this.address = address;
        this.specialist = specialist;
        this.appointments = appointments;
    }
}
