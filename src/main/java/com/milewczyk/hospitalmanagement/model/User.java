package com.milewczyk.hospitalmanagement.model;

import com.milewczyk.hospitalmanagement.enums.SEX;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public class User{

    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String nationality;
    private LocalDateTime dateOfBirth;
    private SEX sex;
}
