package com.milewczyk.hospitalmanagement.repository;

import com.milewczyk.hospitalmanagement.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Page<Appointment> getByDate(LocalDateTime date, Pageable pageable);
    Page<Appointment> getByDoctor_Lastname(String lastname, Pageable pageable);
    Page<Appointment> getByPatient_Lastname(String lastname, Pageable pageable);
}
