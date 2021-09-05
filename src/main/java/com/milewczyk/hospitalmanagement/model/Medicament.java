package com.milewczyk.hospitalmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MEDICAMENTS")
public class Medicament {

    @Id
    private Long id;
    private String name;

    public Medicament(String name) {
        this.name = name;
    }
}
