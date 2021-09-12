package com.milewczyk.hospitalmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "ADDRESSES")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String streetNumber;
    private String apartmentNumber;
    private String postCode;
    private String country;

    public Address(String city, String street, String streetNumber, String apartmentNumber, String postCode, String country) {
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.postCode = postCode;
        this.country = country;
    }
}
