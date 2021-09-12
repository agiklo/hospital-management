package com.milewczyk.hospitalmanagement.model;

import com.milewczyk.hospitalmanagement.enums.SEX;
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
@EqualsAndHashCode(callSuper = true)
@Table(name = "RELATIVES")
public class Relative extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Address address;

    public Relative(String firstname,
                    String lastname,
                    String phoneNumber,
                    String email,
                    String nationality,
                    LocalDateTime dateOfBirth,
                    SEX sex,
                    Address address) {
        super(firstname, lastname, phoneNumber, email, nationality, dateOfBirth, sex);
        this.address = address;
    }
}
