package com.milewczyk.hospitalmanagement.repository;

import com.milewczyk.hospitalmanagement.model.Prescription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> getByAppointment_Patient_Id(Long id, Pageable pageable);
    List<Prescription> getByAppointment_Doctor_Id(Long id, Pageable pageable);
}
